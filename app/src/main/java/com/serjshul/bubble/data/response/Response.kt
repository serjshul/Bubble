package com.serjshul.bubble.data.response

sealed interface Response<out T> {
    val source: String
}