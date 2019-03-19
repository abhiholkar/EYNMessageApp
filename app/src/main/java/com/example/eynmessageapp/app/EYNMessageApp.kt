/*
 * Created by Abhinav Holkar on 18/03/19 12:06.
 * Last modified 18/03/19 12:06.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.app

import android.app.Application

class EYNMessageApp : Application() {

    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
