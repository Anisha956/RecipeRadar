package com.example.reciperadar.model
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strInstructions: String?,
    val strYoutube: String? = null
)