package com.zdez.getmeaxolotl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) :AndroidViewModel(application) {
    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getData()
    }

    private fun getData() {
        Api.retrofitService.getData().enqueue(object: Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                        _response.value = "Failure: ${t.message}"
            }
        })

    }
}
