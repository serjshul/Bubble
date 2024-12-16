package com.serjshul.bubble.data.response

data class Success<out T>(
    override val info: String,
    val data: T? = null,
) : Response<T>