package com.serjshul.bubble.data.response

data class Failure(
    override val source: String,
    val e: Exception
) : Response<Nothing>