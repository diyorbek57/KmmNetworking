package uz.shadowcompany.kmmnetworking.api.service.register

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import uz.shadowcompany.kmmnetworking.api.Client.Companion.client
import uz.shadowcompany.kmmnetworking.api.HttpRoutes
import uz.shadowcompany.kmmnetworking.models.DefaultResponse
import uz.shadowcompany.kmmnetworking.models.UserRegister

class RegisterServiceImpl() : RegisterService {



    override suspend fun register(register: UserRegister): DefaultResponse? {
        return try {
            client.post(HttpRoutes.REGISTER) {
                contentType(ContentType.Application.Json)
                setBody(register)
            }.body()
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            println("Error 3xx : ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error 4xx: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error 5xx : ${e.response.status.description}")
            null
        } catch (e: Exception) {
            println("Error e : ${e.message}")
            null
        }
    }
}