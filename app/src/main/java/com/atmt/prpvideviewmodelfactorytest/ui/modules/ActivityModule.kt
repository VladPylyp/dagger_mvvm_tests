package com.atmt.prpvideviewmodelfactorytest.ui.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.atmt.prpvideviewmodelfactorytest.ui.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [
        FragmentModule::class
    ])
    abstract fun contributeMainActivity(): MainActivity
}