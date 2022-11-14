package uz.shadowcompany.kmmnetworking.models

import kotlinx.serialization.Serializable

@Serializable
data class Test(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)