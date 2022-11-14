package uz.shadowcompany.kmmnetworking.api.service.register

import uz.shadowcompany.kmmnetworking.api.Client
import uz.shadowcompany.kmmnetworking.models.DefaultResponse
import uz.shadowcompany.kmmnetworking.models.UserRegister


interface RegisterService {

    suspend fun register(register: UserRegister): DefaultResponse?

    companion object {
        fun create(): RegisterService {
            return RegisterServiceImpl()
        }
    }
}