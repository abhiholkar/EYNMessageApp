/*
 * Created by Abhinav Holkar on 16/03/19 21:01.
 * Last modified 16/03/19 21:01.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.network

import com.example.eynmessageapp.model.TextData
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {


    @POST("/t/EYN/post")
    fun postTextData(@Body textData: TextData) : Call<ResponseBody>

}