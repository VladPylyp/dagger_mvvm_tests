package com.atmt.prpvideviewmodelfactorytest.managers

import android.content.res.Resources
import javax.inject.Inject

class AndroidResourcesManager @Inject constructor(val resources: Resources) : ResourcesManager {

    override fun getString(resId: Int, vararg arguments: String): String {
       return arguments.takeIf { it.any() }?.let {
           resources.getString(resId, it)
       }?: resources.getString(resId)
    }
}