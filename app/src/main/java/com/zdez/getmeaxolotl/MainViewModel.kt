package com.zdez.getmeaxolotl


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _response = MutableLiveData<Properties>()

    val response: LiveData<Properties>
        get() = _response

    init {
        getData()
    }

    fun getData() {
        Api.retrofitService.getData().enqueue(object: Callback<Properties>{
            override fun onResponse(call: Call<Properties>, response: Response<Properties>) {
                _response.value = response.body()
            }

            override fun onFailure(call: Call<Properties>, t: Throwable) {
                        _response.value?.facts = "Failure: ${t.message}"
            }
        })

    }
}
