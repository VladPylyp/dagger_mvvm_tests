package com.atmt.prpvideviewmodelfactorytest.baseui

import android.content.pm.PackageManager
import android.support.annotation.IdRes
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    companion object {
        private const val REQUEST_PERMISSIONS = 12
        const val FINISH_CODE = 1554
        const val CHECKOUT_RELOAD_CODE = 1555
    }

    /**
     * Callback interfaces
     * Uses for getting now if the requested permissions are granted
     * */
    interface IPermissionResultCallback{
        fun onPermissionGranted()
        fun onPermissionDenied()
    }

    private var permissionCallback: IPermissionResultCallback? = null


    fun checkPermissions(permissions: List<String>, callback: IPermissionResultCallback){
        permissionCallback = callback
        val notGrantedPermissionList = mutableListOf<String>()
        permissions.forEach {
            if(ContextCompat.checkSelfPermission(this@BaseActivity,it)
                    != PackageManager.PERMISSION_GRANTED){
                notGrantedPermissionList.add(it)
            }
        }
        if(notGrantedPermissionList.isEmpty()){
            permissionCallback?.onPermissionGranted()
            permissionCallback = null
            return
        }

        ActivityCompat.requestPermissions(
                this,
                notGrantedPermissionList.toTypedArray(),
                REQUEST_PERMISSIONS
        )
    }

    protected fun setFragment(fragment: Fragment, containerId: Int) {
        val newFrag = supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName)
        if (newFrag != null && newFrag.isVisible) {
            return /* do nothing, already here */
        } else {
            replaceFragment(containerId, fragment, (fragment.javaClass.simpleName))
        }
    }
    private fun replaceFragment(@IdRes id: Int, frag: Fragment, tag: String? = frag.javaClass.simpleName){
        supportFragmentManager.beginTransaction().replace(id, frag, tag).commitAllowingStateLoss()
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_PERMISSIONS){
            if(grantResults.isNotEmpty()){
                var isGranted = true
                grantResults.forEach {
                    if(it == PackageManager.PERMISSION_DENIED){
                        isGranted = false
                    }
                }
                if(isGranted){
                    permissionCallback?.onPermissionGranted()
                }else{
                    permissionCallback?.onPermissionDenied()
                }
            }else{
                permissionCallback?.onPermissionDenied()
            }
            permissionCallback = null
        }
    }

}