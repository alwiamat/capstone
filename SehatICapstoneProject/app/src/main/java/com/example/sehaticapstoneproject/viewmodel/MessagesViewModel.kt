package com.example.sehaticapstoneproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessagesViewModel : ViewModel()
{

    private val _text = MutableLiveData<String>().apply {
        value = "This is Messages"
    }
    val text: LiveData<String> = _text
}