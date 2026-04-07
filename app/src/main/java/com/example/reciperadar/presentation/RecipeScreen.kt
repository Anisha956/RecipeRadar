package com.example.reciperadar.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reciperadar.viewmodel.RecipeViewModel
@Composable
fun RecipeScreen() {
    val navController = rememberNavController()
    val viewModel: RecipeViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        // SCREEN 1: LIST + SEARCH
        composable("list") {
            RecipeListScreen(
                viewModel = viewModel,
                onCategoryClick = { category ->
                    navController.navigate("detail/${category.strCategory}")
                },
                onMealClick = { meal ->
                    navController.navigate("mealDetail/${meal.idMeal}")
                }
            )
        }

        // SCREEN 2: CATEGORY DETAIL
        composable("detail/{catName}") { backStackEntry ->
            val catName = backStackEntry.arguments?.getString("catName")

            val categories by viewModel.categories.collectAsState()
            val category = categories.find { it.strCategory == catName }

            category?.let {
                CategoryDetailScreen(
                    category = it,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }

        composable("mealDetail/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")

            val searchResults by viewModel.searchResults.collectAsState()
            val meal = searchResults.find { it.idMeal == mealId }

            meal?.let {
                MealDetailScreen(
                    meal = it,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}
