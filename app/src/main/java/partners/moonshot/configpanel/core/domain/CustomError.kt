package partners.moonshot.configpanel.core.domain

import java.lang.RuntimeException

enum class CustomError {
    INTERNET_ERROR, SERVER_ERROR, UNKNOWN_ERROR, RUNTIME_ERROR
}

fun Exception.getCustomError() : CustomError {
    return when(this){
        is ServerExeption -> CustomError.SERVER_ERROR
        is InternetExeption -> CustomError.INTERNET_ERROR
        is RuntimeException -> CustomError.RUNTIME_ERROR
        else -> CustomError.UNKNOWN_ERROR
    }
}