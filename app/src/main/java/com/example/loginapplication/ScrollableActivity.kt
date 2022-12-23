package com.example.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.Toolbar

class ScrollableActivity : AppCompatActivity() {


    private var uiAtLanguage:AutoCompleteTextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrollable)
        supportActionBar?.hide()
        setUpUi()
    }

    private fun setUpUi() {
        uiAtLanguage = findViewById(R.id.uiActGnder)
        val languages = resources.getStringArray(R.array.str_array_programming_languages)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, languages)
        this.uiAtLanguage?.setAdapter(arrayAdapter)
    }
}