package com.example.reciperadar.data

import com.example.reciperadar.model.CategoriesResponse
import com.example.reciperadar.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

    @GET("search.php")
    suspend fun searchMeals(@Query("s") query: String): MealResponse
}