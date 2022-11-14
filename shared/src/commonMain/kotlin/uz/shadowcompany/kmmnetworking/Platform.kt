package uz.shadowcompany.kmmnetworking

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform