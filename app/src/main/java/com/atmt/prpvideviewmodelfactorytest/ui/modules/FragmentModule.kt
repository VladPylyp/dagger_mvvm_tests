package com.atmt.prpvideviewmodelfactorytest.ui.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.atmt.prpvideviewmodelfactorytest.ui.BlankFragment

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeFragment(): BlankFragment
}