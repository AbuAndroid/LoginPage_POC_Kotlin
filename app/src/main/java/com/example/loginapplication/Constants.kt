package com.example.loginapplication

import java.util.regex.Pattern

class Constants {

    private final val USER_DETAILS = "userdetails"
    private final val USER_NAME = "username"
    private final val USER_EMAIL = "useremail"
    private final val USER_PASSWORD = "userpassword"
    private final val USER_GENDER = "usergender"
    private final val PASSWORD_PATTERN = Pattern.compile("^" + "(?=.*[@#$%^&+=])" +     // at least 1 special character
            "(?=\\S+$)" +            // no white spaces
            ".{4,}" +                // at least 4 characters
            "$");


}