package com.atmt.prpvideviewmodelfactorytest.ui

import android.net.Uri
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import com.atmt.prpvideviewmodelfactorytest.R
import com.atmt.prpvideviewmodelfactorytest.baseui.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

open class MainActivity : BaseActivity(), HasSupportFragmentInjector, BlankFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            setFragment(BlankFragment.newInstance(),R.id.container)
        }
    }

}
