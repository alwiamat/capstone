package com.example.sehaticapstoneproject.model

data class TipsModel (
    var img : Int,
    var name : String ,
    val description : String,
    var expand : Boolean = false
)