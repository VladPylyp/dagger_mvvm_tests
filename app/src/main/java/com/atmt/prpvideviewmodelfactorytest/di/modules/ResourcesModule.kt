package com.atmt.prpvideviewmodelfactorytest.di.modules

import android.app.Activity
import android.content.res.Resources
import com.atmt.prpvideviewmodelfactorytest.managers.AndroidResourcesManager
import com.atmt.prpvideviewmodelfactorytest.managers.ResourcesManager
import dagger.Module
import dagger.Provides

@Module
class ResourcesModule {

    @Provides
    fun provideResources(activity: Activity): Resources{
        return  activity.resources
    }

    @Provides
    fun provideResourceManager(resources: Resources) : ResourcesManager {
        return AndroidResourcesManager(resources)
    }
}