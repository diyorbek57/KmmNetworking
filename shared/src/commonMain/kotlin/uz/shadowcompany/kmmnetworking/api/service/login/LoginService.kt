package uz.shadowcompany.kmmnetworking.api.service.login

import uz.shadowcompany.kmmnetworking.api.Client
import uz.shadowcompany.kmmnetworking.models.DefaultResponse
import uz.shadowcompany.kmmnetworking.models.Test
import uz.shadowcompany.kmmnetworking.models.UserLogin
import uz.shadowcompany.kmmnetworking.models.UserRegister


interface LoginService {

    suspend fun login(login: UserLogin): DefaultResponse?
    suspend fun test(): Test?

    companion object {
        fun create(): LoginService {
            return LoginServiceImpl()
        }
    }
}