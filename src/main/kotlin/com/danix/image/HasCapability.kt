package com.danix.image

interface HasCapability<in T> {

    fun canHandle(params: T): Boolean
}
