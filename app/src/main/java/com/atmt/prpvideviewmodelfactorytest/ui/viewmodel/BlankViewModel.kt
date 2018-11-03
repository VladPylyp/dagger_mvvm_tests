package com.atmt.prpvideviewmodelfactorytest.ui.viewmodel


import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import com.atmt.prpvideviewmodelfactorytest.repositories.TestRepository
import javax.inject.Inject

class BlankViewModel @Inject constructor(private val testRepository: TestRepository) : ViewModel(){
    val stringToShowLiveData = MutableLiveData<String>()

    fun getStringToShow(){
        val observeData = testRepository.getData()
        val observer = object : Observer<String>{
            override fun onChanged(t: String?) {
                t?.let {
                    stringToShowLiveData.postValue(it)
                }
                observeData.removeObserver(this)
            }
        }
        observeData.removeObserver(observer)
        observeData.observeForever(observer)
    }

}
