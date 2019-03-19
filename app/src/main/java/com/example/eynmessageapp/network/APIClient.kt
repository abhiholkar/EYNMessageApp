/*
 * Created by Abhinav Holkar on 16/03/19 21:14.
 * Last modified 16/03/19 21:14.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://ptsv2.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}