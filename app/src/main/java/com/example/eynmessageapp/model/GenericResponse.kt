/*
 * Created by Abhinav Holkar on 16/03/19 20:58.
 * Last modified 16/03/19 20:58.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.model

import com.example.eynmessageapp.model.ResponseState

class GenericResponse(private val iState: ResponseState?) {

    fun getResponseState()= iState
}