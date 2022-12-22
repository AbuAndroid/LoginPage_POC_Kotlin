package com.example.loginapplication

import java.util.regex.Pattern

class Constants {
    companion object{
        const val USER_DETAILS = "userdetails"
        const val USER_NAME = "username"
        const val USER_EMAIL = "useremail"
        const val USER_PASSWORD = "userpassword"
        const val USER_GENDER = "usergender"
        val PASSWORD_PATTERN: Pattern? = Pattern.compile("^" + "(?=.*[@#$%^&+=])" +     // at least 1 special character
                "(?=\\S+$)" +            // no white spaces
                ".{4,}" +                // at least 4 characters
                "$")
    }
}