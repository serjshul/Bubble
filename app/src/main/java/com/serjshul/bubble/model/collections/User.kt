package com.serjshul.bubble.model.collections

import com.serjshul.bubble.model.subcollections.Post
import java.util.Date

data class User(
    val uid: String? = null,

    val nickname: String? = null,
    val name: String? = null,
    val bio: String? = null,
    val dateOfBirth: Date? = null,
    val photoUrl: String? = null,

    val email: String? = null,
    val phone: String? = null,

    val pids: List<String> = emptyList(),
    val cids: List<String> = emptyList(),
    val lids: List<String> = emptyList(),

    val followers: List<String> = emptyList(),
    val following: List<String> = emptyList(),

    val posts: List<Post> = emptyList()
)