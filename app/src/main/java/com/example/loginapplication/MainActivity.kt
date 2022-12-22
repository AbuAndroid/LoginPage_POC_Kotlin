package com.example.loginapplication

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
        setUpSpinner()
        SaveDataToDb()

    }

    private fun SaveDataToDb() {
        var sharedPreference : SharedPreferences = this.getSharedPreferences()
    }

    private fun setUpUi(){
        val userEtName = findViewById<EditText>(R.id.uiEtUserName)
        val userEtEmail = findViewById<EditText>(R.id.uiEtUserEmail)
        val userEtPassword = findViewById<EditText>(R.id.uiEtUserPassword)
        val validationBtn = findViewById<Button>(R.id.uiSubmitButton)

    }
    private fun setUpSpinner(){
        val userSpGender = findViewById<Spinner>(R.id.uiSpUserGender)
        val genderResourse = resources.getStringArray(R.array.str_rray_gender_list)
        val items = ArrayAdapter(this,android.R.layout.simple_spinner_item,genderResourse)
        userSpGender.adapter = items

    }
}