package com.example.job_01.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.job_01.Products
import com.example.job_01.apiInstance
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>> = _products
    init {
        viewModelScope.launch {
            fetchProducts()
        }
    }

    private  suspend fun fetchProducts() {
        try {
            val response =apiInstance.apiService.getProducts()
            _products.postValue(response)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}