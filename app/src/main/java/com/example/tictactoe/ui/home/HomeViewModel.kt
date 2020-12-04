package com.example.tictactoe.ui.home

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tictactoe.login

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Mini - Games+"
    }
    val text: LiveData<String> = _text



}