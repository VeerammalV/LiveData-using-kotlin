package com.example.livedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var resultMutableLiveData = MutableLiveData<Boolean>()
    val resultLiveData : LiveData<Boolean> = resultMutableLiveData

    fun computation(firstNum: Int, secondNum: Int) {
        val addition = firstNum + secondNum

        resultMutableLiveData.value = addition <= 100
    }


}