package com.serjshul.bubble.data.response

data class Failure(
    override val info: String,
    val e: Exception
) : Response<Nothing>