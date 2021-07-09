package com.example.shibesample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shibesample.data.models.ShibeResponse
import com.example.shibesample.data.repo.ShibeRepo
import com.example.shibesample.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _shibes = MutableLiveData<Resource<ShibeResponse>>()
    val shibes: LiveData<Resource<ShibeResponse>> get() = _shibes

    init {
        getShibes()
    }

    private fun getShibes() {
        _shibes.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val shibeResource = ShibeRepo.getShibes(50)
            _shibes.postValue(shibeResource)
        }
    }
}