package com.atmt.prpvideviewmodelfactorytest.managers

interface ResourcesManager {
    fun getString(resId: Int, vararg arguments: String = emptyArray()): String
}