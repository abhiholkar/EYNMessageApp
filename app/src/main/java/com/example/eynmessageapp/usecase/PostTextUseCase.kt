/*
 * Created by Abhinav Holkar on 16/03/19 21:16.
 * Last modified 16/03/19 21:16.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.usecase

import com.example.eynmessageapp.network.APIClient
import io.reactivex.Observable

class PostTextUseCase {
    lateinit var apiClient: APIClient

    fun postText():Observable<Boolean>{
        apiClient = APIClient();
        return Observable.just(true)
    }
}