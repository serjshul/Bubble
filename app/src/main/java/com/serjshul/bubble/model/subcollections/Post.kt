package com.serjshul.bubble.model.subcollections

import java.util.Date

data class Post (
    val id: String? = null,

    val articleId: String? = null,
    val userId: String? = null,

    val isReposted: Boolean? = null,

    val date: Date? = null
)