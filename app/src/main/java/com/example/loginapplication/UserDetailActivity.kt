package com.example.loginapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserDetailActivity : AppCompatActivity() {

    private var uiEtUserName: TextView? = null
    private var uiEtUserEmail: TextView? = null
    private var uiEtUserPassword: TextView? = null
    private var uiSpGender: TextView? = null

    private val sharedPreferences : CommonSharedPreferences by lazy {
        CommonSharedPreferences(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        setUpUI()
        setDataToUi()
    }

    private fun setUpUI() {
        uiEtUserName = findViewById(R.id.uiTvUsername)
        uiEtUserEmail = findViewById(R.id.uiTvUseremail)
        uiEtUserPassword = findViewById(R.id.uiTvUserpassword)
        uiSpGender = findViewById(R.id.uiTvUserGender)
    }

    private fun setDataToUi() {
        uiEtUserName?.text = sharedPreferences.getUserName()
        uiEtUserEmail?.text = sharedPreferences.getUserEmail()
        uiEtUserPassword?.text = sharedPreferences.getUserPassword()
        uiSpGender?.text = sharedPreferences.getUserGender()

    }
}