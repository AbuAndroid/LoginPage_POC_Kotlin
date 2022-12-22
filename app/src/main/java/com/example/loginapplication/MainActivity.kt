package com.example.loginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.loginapplication.Constants.Companion.PASSWORD_PATTERN


class MainActivity : AppCompatActivity() {
    private var uiEtUserName: EditText? = null
    private var uiEtUserEmail: EditText? = null
    private var uiEtUserPassword: EditText? = null
    private var uiSubmitButton: Button? = null
    private var uiSpGender: Spinner? = null
    private val sharedPreferences: CommonSharedPreferences by lazy {
        CommonSharedPreferences(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
        setUpSpinner()
        setUpLiserners()
        if (checkPreviousDataInDb() != null) {
            goToNextActivity()
            finish()
        }
    }

    private fun setUpLiserners() {
        uiSubmitButton?.setOnClickListener {
            if (isValidName() && isValidEmail() && isValidPassword()) {
                saveDataToDb()
                goToNextActivity()
            }
        }
    }

    private fun goToNextActivity() {
        val intent = Intent(this, UserDetailActivity::class.java)
        startActivity(intent)
    }

    private fun checkPreviousDataInDb(): String? {
        return sharedPreferences.getUserName()
    }

    private fun saveDataToDb() {
        val userName: String = uiEtUserName?.text.toString().trim()
        val userEmail: String = uiEtUserEmail?.text.toString().trim()
        val userPassword: String = uiEtUserPassword?.text.toString().trim()
        val userGender: String = uiSpGender?.selectedItem.toString()

        sharedPreferences.setUserName(userName)
        sharedPreferences.setUserEmail(userEmail)
        sharedPreferences.setUserPassword(userPassword)
        sharedPreferences.setUserGender(userGender)
    }

    private fun setUpUi() {
        uiEtUserName = findViewById(R.id.uiEtUserName)
        uiEtUserEmail = findViewById(R.id.uiEtUserEmail)
        uiEtUserPassword = findViewById(R.id.uiEtUserPassword)
        uiSubmitButton = findViewById(R.id.uiSubmitButton)
    }

    private fun setUpSpinner() {
        uiSpGender = findViewById(R.id.uiSpUserGender)
        val genderResourse = resources.getStringArray(R.array.str_rray_gender_list)
        val items = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderResourse)
        uiSpGender!!.adapter = items

    }

    private fun isValidName(): Boolean {
        val username = uiEtUserName?.text.toString().trim()
        return if (username.isEmpty()
        ) {
            uiEtUserName?.error = getString(R.string.msg_enter_valid_username)
            false
        } else {
            true
        }
    }

    private fun isValidEmail(): Boolean {
        val emailInput = uiEtUserEmail?.text.toString().trim()
        return if (emailInput.isEmpty()) {
            uiEtUserEmail?.error = getString(R.string.msg_enter_empty_email)
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            uiEtUserEmail?.error = getString(R.string.msg_enter_vaid_email)
            false
        } else {
            uiEtUserEmail?.error = null
            true
        }
    }

    private fun isValidPassword(): Boolean {
        val passwordInput: String = uiEtUserPassword?.text.toString().trim()
        return if (passwordInput.isEmpty()) {
            uiEtUserPassword?.error = getString(R.string.msg_enter_empty_password)
            false
        } else if (!PASSWORD_PATTERN?.matcher(passwordInput)?.matches()!!) {
            uiEtUserPassword?.error = getString(R.string.msg_enter_valid_password)
            false
        } else {
            uiEtUserPassword?.error = null
            true
        }
    }
}