package uz.itschool.mathkidsnew.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import uz.itschool.mathkidsnew.screens.homescreen.HomeScreen
import uz.itschool.mathkidsnew.screens.menuscreen.MenuScreen
import uz.itschool.mathkidsnew.screens.questionscreen.QuestionScreen
import uz.itschool.mathkidsnew.screens.recordscreen.RecordScreen
import uz.itschool.mathkidsnew.screens.results.Results
import uz.itschool.mathkidsnew.screens.splashscreen.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    )
    {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screens.Menu.route) {
            MenuScreen(navController)
        }
        composable(route = Screens.Result.route) {
            Results(navController)
        }
        composable(route = Screens.Questions.route, arguments = listOf(
            navArgument("level"){
                type = NavType.StringType
            }
        )){entry ->
            val level = entry.arguments?.getString("level")!!
            QuestionScreen(navController = navController, level)
        }
        composable(route = Screens.Record.route, arguments = listOf(
            navArgument("level"){
                type = NavType.StringType
            },
            navArgument("score"){
                type = NavType.IntType
            },
            navArgument("questionsNumber"){
                type = NavType.IntType
            }
        )){entry ->
            val level = entry.arguments?.getString("level")!!
            val score = entry.arguments?.getInt("score")!!
            val questionsNumber = entry.arguments?.getInt("questionsNumber")!!
            RecordScreen(navController = navController, level, score, questionsNumber)
        }
    }
}