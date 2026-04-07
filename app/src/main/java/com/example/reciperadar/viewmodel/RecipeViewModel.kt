package com.example.reciperadar.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reciperadar.data.RetrofitClient
import com.example.reciperadar.model.Category
import com.example.reciperadar.model.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
class RecipeViewModel : ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories


    private val _searchResults = MutableStateFlow<List<Meal>>(emptyList())
    val searchResults: StateFlow<List<Meal>> = _searchResults

    var searchQuery = mutableStateOf("")
    val isSearching: Boolean get() = searchQuery.value.isNotEmpty()

    init { fetchCategories() }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getCategories()
                _categories.value = response.categories
            } catch (e: Exception) { e.printStackTrace() }
        }
    }

    fun onSearchTextChange(newText: String) {
        searchQuery.value = newText
        if (newText.length > 2) {
            performSearch(newText)
        } else if (newText.isEmpty()) {
            _searchResults.value = emptyList()
        }
    }

    private val _isSearchingLoading = MutableStateFlow(false)
    val isSearchingLoading: StateFlow<Boolean> = _isSearchingLoading

    private fun performSearch(query: String) {
        viewModelScope.launch {
            _isSearchingLoading.value = true
            try {
                val response = RetrofitClient.apiService.searchMeals(query)
                _searchResults.value = response.meals ?: emptyList()
            } finally {
                _isSearchingLoading.value = false
            }
        }
    }
}