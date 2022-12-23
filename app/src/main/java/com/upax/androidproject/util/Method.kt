package com.upax.androidproject.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object Method {

    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.getActiveNetworkInfo()
        if (activeNetwork != null) {
           return true
        }
        return false
    }
}