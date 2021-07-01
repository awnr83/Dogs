package com.example.dogs.dogDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DetailViewModel(private val img: String):ViewModel() {

    private val _imgString= MutableLiveData<String>()
    val imgString: LiveData<String>
        get()= _imgString

    init {
        _imgString.value=img
    }
}