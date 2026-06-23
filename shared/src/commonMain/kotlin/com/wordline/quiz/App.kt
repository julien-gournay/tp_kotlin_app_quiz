package com.wordline.quiz
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.wordline.quiz.screens.QuestionScreen
import com.wordline.quiz.screens.ScoreScreen
import com.wordline.quiz.screens.WelcomeScreen
import com.wordline.quiz.screens.HistoryScreen

import com.worldline.quiz.QuizViewModel
import kotlinx.serialization.Serializable

@Serializable
object WelcomeRoute

@Serializable
object QuizRoute

@Serializable
data class ScoreRoute(val score: Int, val questionSize: Int)

@Serializable
object HistoryRoute


@Composable
fun App(
    navController: NavHostController = rememberNavController(),
    quizViewModel: QuizViewModel = QuizViewModel(),
) {

    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = WelcomeRoute,
        ) {


            composable<WelcomeRoute>() {
                WelcomeScreen(
                    onStartButtonPushed = {
                        navController.navigate(route = QuizRoute)
                    },
                    viewHistoryButtonPushed = {
                        navController.navigate(route = HistoryRoute)
                    }
                )
            }
            composable<QuizRoute>() {
                val questions by quizViewModel.questionState.collectAsState()
                QuestionScreen(
                    questions = questions,

                    onFinishButtonPushed = {
                            score: Int, questionSize: Int -> navController.navigate(route = ScoreRoute(score, questionSize))
                    }
                )
            }
            composable<ScoreRoute> { backStackEntry ->
                val scoreRoute: ScoreRoute = backStackEntry.toRoute<ScoreRoute>()
                var isNewRecord by remember { mutableStateOf(false) }

                LaunchedEffect(Unit) {
                    isNewRecord = quizViewModel.addHistory(scoreRoute.score, scoreRoute.questionSize)
                }

                ScoreScreen(
                    score = scoreRoute.score,
                    total = scoreRoute.questionSize,
                    isNewRecord = isNewRecord,
                    onResetButtonPushed = {
                        navController.navigate(route = QuizRoute)
                    },
                    onViewHistoryPushed = {
                        navController.navigate(route = HistoryRoute)
                    },
                    onBackHomePushed = {
                        navController.navigate(route = WelcomeRoute)
                    }
                )
            }
            composable<HistoryRoute>() {
                val history by quizViewModel.historyState.collectAsState()
                HistoryScreen(
                    history = history,
                    onBackToWelcomePushed = {
                        navController.navigate(route = WelcomeRoute)
                    },
                    onResetHistoryPushed = {
                        quizViewModel.resetHistory()
                    }
                )
            }
        }
    }
}
