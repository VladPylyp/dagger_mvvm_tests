package com.atmt.prpvideviewmodelfactorytest
import android.app.Activity
import android.support.multidex.MultiDexApplication
import com.atmt.prpvideviewmodelfactorytest.di.AppComponent
import com.atmt.prpvideviewmodelfactorytest.di.initInjections
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class BaseApplication : MultiDexApplication(), HasActivityInjector {

    companion object {
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var dispatchingInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()

        appComponent = initInjections(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> =
            dispatchingInjector

}
