package uz.shadowcompany.kmmnetworking

import io.ktor.client.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class Greeting {
    private val client = HttpClient(){
        install(Logging)
    }

    suspend fun greeting(): String {
        val response = client.get("https://jsonplaceholder.typicode.com/todos/1")
        return response.bodyAsText()
    }
}