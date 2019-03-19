/*
 * Created by Abhinav Holkar on 16/03/19 20:54.
 * Last modified 16/03/19 20:54.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.eynmessageapp.app.EYNMessageApp
import com.example.eynmessageapp.model.GenericResponse
import com.example.eynmessageapp.model.ResponseState
import com.example.eynmessageapp.model.TextData
import com.example.eynmessageapp.network.APIClient
import com.example.eynmessageapp.network.APIService
import com.example.eynmessageapp.util.DBManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {

    private lateinit var mutableLiveData: MutableLiveData<GenericResponse>

    fun postTextData(data: String, isNetworkAvailable: Boolean): MutableLiveData<GenericResponse> {

        mutableLiveData = MutableLiveData()
        val dbManager = DBManager.instance()
        var postText = data

        if (isNetworkAvailable) {

            //Network available - Post the text Data
            val apiClient = APIClient();
            if(dbManager.getTextCache()) {
                postText = dbManager.getPostText().plus("|").plus(postText)
                dbManager.setTextCache(false)
            }

            val call = apiClient.getRetrofit().create(APIService::class.java).postTextData(TextData(postText))
            call.enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d(javaClass.simpleName, "onFailure : --> " + t.message)
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    Log.d(javaClass.simpleName, "RESPONSE : --> " + response.isSuccessful)
                    mutableLiveData.value = GenericResponse(ResponseState.SUCCESS)
                }

            })
        } else {
            //Cache the data
            dbManager.savePostText(data);
            mutableLiveData.value = GenericResponse(ResponseState.CACHED)

        }
        return mutableLiveData
    }


}