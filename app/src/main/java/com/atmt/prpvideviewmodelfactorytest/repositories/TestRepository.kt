package com.atmt.prpvideviewmodelfactorytest.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.atmt.prpvideviewmodelfactorytest.R
import com.atmt.prpvideviewmodelfactorytest.managers.ResourcesManager
import javax.inject.Inject

class TestRepository @Inject constructor(private val resources : ResourcesManager){

    fun getData(): LiveData<String> {
        val dataLiveData = MutableLiveData<String>()
        val stringToShow = resources.getString(R.string.hello_blank_fragment)
        dataLiveData.postValue(stringToShow)
        return dataLiveData
    }
}