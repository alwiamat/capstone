package com.example.sehaticapstoneproject.model

data class MessageModel (
    val message: String,
    val createdAt: Long,
    val type: Int,

    // sender data
    val userId: Int,
    val nickname: String,
    val profileUrl: String
)