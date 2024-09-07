package com.serjshul.bubble.model.subcollections

import java.util.Date

data class Post (
    val pid: String? = null,

    val rid: String? = null,
    val uid: String? = null,

    val isReposted: Boolean? = null,

    val date: Date? = null
)