package com.serjshul.bubble.model.collections

import com.serjshul.bubble.model.subcollections.Post
import java.util.Date

data class User(
    val id: String? = null,

    val nickname: String? = null,
    val name: String? = null,
    val bio: String? = null,
    val dateOfBirth: Date? = null,
    val photoUrl: String? = null,

    val email: String? = null,
    val phone: String? = null,

    val articleIds: List<String> = emptyList(),
    val commentIds: List<String> = emptyList(),
    val likeIds: List<String> = emptyList(),

    val followers: List<String> = emptyList(),
    val following: List<String> = emptyList(),

    val posts: List<Post> = emptyList()
)