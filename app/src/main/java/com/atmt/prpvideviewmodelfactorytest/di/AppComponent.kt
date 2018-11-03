package com.atmt.prpvideviewmodelfactorytest.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.atmt.prpvideviewmodelfactorytest.BaseApplication
import com.atmt.prpvideviewmodelfactorytest.di.modules.AppViewModelsFactoryModule
import com.atmt.prpvideviewmodelfactorytest.di.modules.ResourcesModule
import com.atmt.prpvideviewmodelfactorytest.ui.modules.ActivityModule
import javax.inject.Singleton

/*Global Component*/
@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppViewModelsFactoryModule::class,
            ResourcesModule::class,
            ActivityModule::class

        ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}