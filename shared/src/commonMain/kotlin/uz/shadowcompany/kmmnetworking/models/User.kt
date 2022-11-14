package uz.shadowcompany.kmmnetworking.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(val id: String)

@Serializable
data class UserRegister(
    val phone: String,
    val name: String,
    val age: String,
    val password: String,
    val password_confirmation: String
)


@Serializable
data class UserLogin(
    val phone: String,
    val password: String
)