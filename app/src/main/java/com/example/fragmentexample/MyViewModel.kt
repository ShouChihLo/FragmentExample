package com.example.fragmentexample

import android.util.Log
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    var counter = 0

    fun addOne() {
        counter += 1
        Log.i("Main", counter.toString())
    }

    fun minusOne() {
        counter -= 1
        Log.i("Main", counter.toString())
    }
}