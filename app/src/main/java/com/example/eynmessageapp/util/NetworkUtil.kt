/*
 * Created by Abhinav Holkar on 18/03/19 11:50.
 * Last modified 18/03/19 11:50.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.util

import android.content.Context
import android.net.ConnectivityManager


class NetworkUtil {

    companion object {

        fun isNetworkAvailable(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnected
        }


    }
}
