/*
 * Created by Abhinav Holkar on 18/03/19 12:03.
 * Last modified 18/03/19 12:03.
 * Copyright (c) 2019.
 */

package com.example.eynmessageapp.util


import android.content.Context
import com.example.eynmessageapp.app.EYNMessageApp


class DBManager {


    companion object {
        private val instance: DBManager? = DBManager()
        private val dbName = "EYN_DB"
        private val context = EYNMessageApp.instance()
        val pref = context.getSharedPreferences(dbName, Context.MODE_PRIVATE)
        val editor = pref.edit()
        fun instance() = instance!!
    }

    fun savePostText(postText: String?) {

        if (pref.contains(BundleConstants.BUNDLE_POST_TEXT_CACHE) && pref.getBoolean(BundleConstants.BUNDLE_POST_TEXT_CACHE, false)) {
            val cacheText = pref.getString(BundleConstants.BUNDLE_POST_TEXT_KEY, "").plus("|").plus(postText)

            editor.putString(BundleConstants.BUNDLE_POST_TEXT_KEY, cacheText)
        } else {
            editor.putString(BundleConstants.BUNDLE_POST_TEXT_KEY, postText)

        }
        editor.putBoolean(BundleConstants.BUNDLE_POST_TEXT_CACHE, true);
        editor.commit()
    }


    fun getPostText(): String? {
        return pref.getString(BundleConstants.BUNDLE_POST_TEXT_KEY, "")
    }

    fun getTextCache(): Boolean {
        return pref.getBoolean(BundleConstants.BUNDLE_POST_TEXT_CACHE, false)
    }


    fun setTextCache(textCache: Boolean) {

        if (!textCache) {
            editor.clear();
        }
        editor.putBoolean(BundleConstants.BUNDLE_POST_TEXT_CACHE, textCache)
        editor.commit()
    }


}