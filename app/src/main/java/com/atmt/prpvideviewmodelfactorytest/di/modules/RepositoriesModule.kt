package com.atmt.prpvideviewmodelfactorytest.di.modules

import android.content.res.Resources
import com.atmt.prpvideviewmodelfactorytest.managers.ResourcesManager
import com.atmt.prpvideviewmodelfactorytest.repositories.TestRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {


    @Provides
    fun provideTestRepo(resourcesManager: ResourcesManager): TestRepository{
        return TestRepository(resourcesManager)
    }
}