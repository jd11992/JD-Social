package com.jduong.jdsocial

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import androidx.room.util.StringUtil
import com.jduong.jdsocial.data.api.retrofit.ApiFactory
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.MockitoAnnotations
import java.util.*
import java.util.regex.Pattern
import kotlin.coroutines.ContinuationInterceptor
import kotlin.system.measureTimeMillis

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class viewModelTest(private val dispatcher : CoroutineDispatcher) : ViewModel(){
    private var isSessionExpired = false

    suspend fun checkSessionExpiry(): Boolean {
        withContext(Dispatchers.IO) {
            delay(5_000) // to simulate a heavy weight operations
            isSessionExpired = true
        }
        return isSessionExpired
    }

    private var postData : MutableLiveData<Any> = MutableLiveData<Any>()
    val postDataSet : LiveData<Any> = postData

    fun getData() : Any = postData

    suspend fun saveSessionData(){
        viewModelScope.launch(dispatcher) {
            val mFitService = ApiFactory.placeHolderApi
            val post = mFitService.posts(0)
            postData.value = post.toString()
          /*  val calendar = Calendar.getInstance()
            val timestamp = calendar.time
            postData.value = "Good afternoon its:$timestamp"*/

        }
    }

}
@ExperimentalCoroutinesApi
class MainCoroutineRule : TestWatcher(), TestCoroutineScope by TestCoroutineScope() {

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(this.coroutineContext[ContinuationInterceptor] as CoroutineDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }

}
@ExperimentalCoroutinesApi
class ExampleUnitTest {
    private val testDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testsSaveSessionData() = runBlockingTest {
        val viewTest = viewModelTest(testDispatcher)

        viewTest.saveSessionData()

        val userData = viewTest.getData()
        val calendar = Calendar.getInstance()
        val timestamp = calendar.time
        assertEquals("Good afternoon its:$timestamp", userData)
    }



    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }



    @Test
    fun connection(){



    }

    @Test
    fun letter_isCorrect() {
        val stringSequence = arrayOf("Test", "1Test", "test")
        //val patternValidation : Pattern = Pattern.compile("[A-Z]")


        for (testValues in stringSequence) {
            //Get first character
            val firstCharacter = testValues[0]
            //Assert true  if the first character contains A-Z or assert error if false

            assert(Character.isUpperCase(firstCharacter))

        }


    }

}

