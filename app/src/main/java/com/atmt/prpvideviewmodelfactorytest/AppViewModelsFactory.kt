package com.atmt.prpvideviewmodelfactorytest

import android.arch.lifecycle.ViewModel
import android.util.ArrayMap
import com.atmt.prpvideviewmodelfactorytest.di.AppViewModelsComponent
import com.atmt.prpvideviewmodelfactorytest.ui.viewmodel.BlankViewModel
import java.util.concurrent.Callable

class AppViewModelsFactory(private val appViewModelsComponent: AppViewModelsComponent) :
        BaseViewModelFactory() {

    override fun fillViewModels(creators: ArrayMap<Class<*>, Callable<out ViewModel>>) {
        creators[BlankViewModel::class.java] = Callable { appViewModelsComponent.provideBlankViewModel() }
    }

}