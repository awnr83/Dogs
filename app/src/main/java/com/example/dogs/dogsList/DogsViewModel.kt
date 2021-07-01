package com.example.dogs.dogsList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogs.network.DogsApi
import kotlinx.coroutines.launch
import java.lang.Exception

class DogsViewModel():ViewModel() {

    var url= MutableLiveData<String>()

    private val _list= MutableLiveData<List<String>>()
    val list:LiveData<List<String>>
        get()= _list

    private val _imgString= MutableLiveData<String>()
    val imgString: LiveData<String>
        get()=_imgString
    fun onDogClicked(img: String){
        _imgString.value=img
    }
    fun onNavigate(){
        _imgString.value=null
    }

    private val _datosOk=MutableLiveData<Boolean>()
    val datosOk: LiveData<Boolean>
        get() = _datosOk

    fun faltanDatos(){
        _datosOk.value=false
    }

    fun getListado(){
        if(!url.value.isNullOrEmpty()) {
            viewModelScope.launch {
                try {
                    val dog = DogsApi.retrofitService.getListPerros("${url.value}/images")
                    if (dog.status != "error") {
                        _list.value = dog.images ?: emptyList()
                    }
                } catch (e: Exception) {
                    Log.i("alfredo", "error: ${e.message}")
                }
            }
        }else
            _datosOk.value=true
    }


    init {
        _datosOk.value=false
    }
}