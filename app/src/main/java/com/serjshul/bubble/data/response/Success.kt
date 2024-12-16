package com.serjshul.bubble.data.response

data class Success<out T>(
    override val source: String,
    val data: T? = null,
) : Response<T>