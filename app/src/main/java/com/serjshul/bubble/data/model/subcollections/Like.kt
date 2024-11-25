package com.serjshul.bubble.data.model.subcollections

import java.util.Date

data class Like (
    val id: String? = null,

    val articleId: String? = null,
    val userId: String? = null,
    val nickname: String? = null,
    val photoUrl: String? = null,

    val date: Date? = null
)