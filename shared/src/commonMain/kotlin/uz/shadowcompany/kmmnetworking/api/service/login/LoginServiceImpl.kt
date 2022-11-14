package uz.shadowcompany.kmmnetworking.api.service.login

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import uz.shadowcompany.kmmnetworking.api.Client.Companion.client
import uz.shadowcompany.kmmnetworking.api.HttpRoutes
import uz.shadowcompany.kmmnetworking.models.DefaultResponse
import uz.shadowcompany.kmmnetworking.models.Test
import uz.shadowcompany.kmmnetworking.models.UserLogin
import kotlin.math.log

class LoginServiceImpl() : LoginService {



    override suspend fun login(login: UserLogin): DefaultResponse? {
        return try {
             client.submitForm(
               url = HttpRoutes.LOGIN,
               formParameters = Parameters.build {
                   append("phone", login.phone)
                   append("password", login.password)

               }).body<DefaultResponse>()
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
            println("Error e :"+ e)
            null
        }
    }
    override suspend fun test(): Test? {
        return try {
               client
               .submitForm(
               url = "https://jsonplaceholder.typicode.com/posts",
               formParameters = Parameters.build {
                   append("title", "JetBrains")
                   append("body", "example@jetbrains.com")
                   append("userId", "1")

               }).body<Test>()
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
            println("Error e :"+ e)
            null
        }
    }
}