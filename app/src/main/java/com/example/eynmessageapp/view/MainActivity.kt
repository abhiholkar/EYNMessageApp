/*
 * Created by Abhinav Holkar on 16/03/19 20:19.
 * Last modified 16/03/19 20:17.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.eynmessageapp.R
import com.example.eynmessageapp.model.GenericResponse
import com.example.eynmessageapp.model.ResponseState
import com.example.eynmessageapp.util.NetworkUtil
import com.example.eynmessageapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        post.setOnClickListener {
            if (TextUtils.isEmpty(edit_field.text)) {
                showEnterTextMessage()
            } else {
                postData(edit_field.text.toString())
            }
        }

    }

    override fun onResume() {
        super.onResume()
    }

    private fun showEnterTextMessage() {
        Toast.makeText(this, getString(R.string.enter_text), Toast.LENGTH_SHORT).show()
    }


    private fun postData(postText: String) {
        val isNetworkAvailable = NetworkUtil.isNetworkAvailable(this);
        mainViewModel.postTextData(postText,isNetworkAvailable).observe(this, object : Observer<GenericResponse> {
            override fun onChanged(t: GenericResponse?) {
                showMessage(t?.getResponseState())

            }
        })
    }

    private fun showMessage(iState: ResponseState?) {
        var iStateText = getString(R.string.post_success_text);
        when (iState) {
            ResponseState.SUCCESS -> iStateText = getString(R.string.post_success_text)
            ResponseState.CACHED -> iStateText = getString(R.string.data_post_cached)
            ResponseState.FAIL -> iStateText = getString(R.string.data_post_failed)
        }
        Toast.makeText(this, iStateText, Toast.LENGTH_SHORT).show();


    }


}
