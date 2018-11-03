package com.atmt.prpvideviewmodelfactorytest.di.modules

import dagger.Module
import dagger.Provides
import com.atmt.prpvideviewmodelfactorytest.AppViewModelsFactory
import com.atmt.prpvideviewmodelfactorytest.di.AppViewModelsComponent

@Module(subcomponents = [
    AppViewModelsComponent::class
])
class AppViewModelsFactoryModule {

    @Provides
    fun provideAppViewModelFactory(builder: AppViewModelsComponent.Builder): AppViewModelsFactory {
        return AppViewModelsFactory(builder.build())
    }

}