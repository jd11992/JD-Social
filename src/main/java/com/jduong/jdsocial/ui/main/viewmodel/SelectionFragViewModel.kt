package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.*
import com.jduong.jdsocial.data.repository.UserSelectionRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class SelectionFragViewModel(private val userPref : UserSelectionRepository) : ViewModel() {

    fun savePostSelection(enabled : Boolean){
        viewModelScope.launch{
            userPref.savePostSelection(enabled)
        }
    }

    fun checkPostSelection(): LiveData<UserSelectionRepository.Selection>{
        return userPref.postTrackerPrefFlow.asLiveData()
    }

}
class SelectionViewModelFactory(private val userPreference : UserSelectionRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SelectionFragViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return SelectionFragViewModel(userPreference) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}