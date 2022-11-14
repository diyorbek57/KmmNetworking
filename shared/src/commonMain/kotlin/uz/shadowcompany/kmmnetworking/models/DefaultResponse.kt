package uz.shadowcompany.kmmnetworking.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class DefaultResponse(
    val data: String,
    val status: Boolean
)