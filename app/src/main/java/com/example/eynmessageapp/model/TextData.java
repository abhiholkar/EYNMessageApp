/*
 * Created by Abhinav Holkar on 16/03/19 21:39.
 * Last modified 16/03/19 21:39.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TextData {

    @SerializedName("data")
    @Expose
    private String data;

    public TextData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }


}