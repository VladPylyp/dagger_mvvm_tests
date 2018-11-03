package com.atmt.prpvideviewmodelfactorytest.di

import com.atmt.prpvideviewmodelfactorytest.ui.viewmodel.BlankViewModel
import dagger.Subcomponent
@Subcomponent
interface AppViewModelsComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): AppViewModelsComponent
    }

    fun provideBlankViewModel(): BlankViewModel

}