package com.example.loginapplication

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.*

class CommonSharedPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(Constants.USER_DETAILS, Context.MODE_PRIVATE)
    private val editor: Editor? = sharedPreferences.edit()

    fun getUserName(): String? {
        return sharedPreferences.getString(Constants.USER_NAME, null)
    }

    fun getUserEmail(): String? {
        return sharedPreferences.getString(Constants.USER_EMAIL, null)
    }

    fun getUserPassword():String?{
        return  sharedPreferences.getString(Constants.USER_PASSWORD,null)
    }

    fun getUserGender(): String? {
        return sharedPreferences.getString(Constants.USER_GENDER, null)
    }

    fun setUserName(name: String?) {

        editor?.putString(Constants.USER_NAME, name)?.apply()
    }

    fun setUserEmail(email:String?){
        editor?.putString(Constants.USER_EMAIL,email)?.apply()
    }

    fun setUserPassword(password:String?){
        editor?.putString(Constants.USER_PASSWORD,password)?.apply()
    }

    fun setUserGender(gender:String?){
        editor?.putString(Constants.USER_GENDER,gender)?.apply()
    }
}

