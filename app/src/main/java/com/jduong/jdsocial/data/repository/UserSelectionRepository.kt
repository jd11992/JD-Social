package com.jduong.jdsocial.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey

import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.datastore : DataStore<Preferences> by preferencesDataStore("settings")
class UserSelectionRepository private constructor(context : Context) {
 private val datastore = context.datastore

    object PreferencesKey {
        val POST_ENABLED = stringPreferencesKey("post_enabled")
    }
    enum class Selection {
        POST_VIEW, ALBUM_VIEW, NOT_SELECTED
    }

    suspend fun savePostSelection(selected : Boolean){
        val selection = when (selected){
            true ->Selection.POST_VIEW.toString()
            false -> Selection.ALBUM_VIEW.toString()
        }

        datastore.edit { preferences -> preferences[PreferencesKey.POST_ENABLED] = selection }
    }

    val postTrackerPrefFlow : Flow<Selection> = datastore.data
        .catch {
            exception->
            if (exception is IOException){
               emit(emptyPreferences())
            }else{
                throw exception
            }

        }.map {  preferences ->
            val strValue = preferences[PreferencesKey.POST_ENABLED] ?: Selection.NOT_SELECTED.toString()
            strValue.asEnumOrDefault<Selection>()
        }

    companion object {
        @Volatile
        private var INSTANCE : UserSelectionRepository? = null

        fun getInstance(context : Context) : UserSelectionRepository {
            return INSTANCE?: synchronized(this) {
                val instances = UserSelectionRepository(context)
                INSTANCE = instances
                instances
            }
        }
    }

    private inline fun <reified T : Enum<T>> String.asEnumOrDefault(): T =
        enumValues<T>().first { it.name.equals(this, ignoreCase = true) }

}