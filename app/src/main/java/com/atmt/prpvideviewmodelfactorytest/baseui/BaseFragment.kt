package com.atmt.prpvideviewmodelfactorytest.baseui
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


abstract class BaseFragment: Fragment(), Injectable{

    companion object {
        const val REQUEST_SIGN_IN = 5
    }

    /*Using for getting layout id to be inflated*/
    @LayoutRes
    abstract fun layoutId(): Int

    /*Using for triggering inflating finished event*/
    abstract fun onViewReady(inflatedView: View, args: Bundle?)

    /*Using for initializing view models with viewModelProvider*/
    abstract fun initViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(layoutId(),container,false)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewReady(view,savedInstanceState)
    }

}