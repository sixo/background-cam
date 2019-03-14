package eu.sisik.backgroundcam

import android.app.ActivityManager
import android.content.Context

/**
 * Copyright (c) 2019 by Roman Sisik. All rights reserved.
 */
fun isServiceRunning(context: Context, serviceClass: Class<*>): Boolean {
    try {
        val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?
        for (service in manager!!.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return false
}