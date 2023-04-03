package com.example.ecommerceappdemo.models

data class UserRegisterModel(
    private val name : String,
    private val email : String,
    private val password : String,
    private val conPassword : String,

)
