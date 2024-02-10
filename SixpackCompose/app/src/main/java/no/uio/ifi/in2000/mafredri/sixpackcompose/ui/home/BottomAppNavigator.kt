package no.uio.ifi.in2000.mafredri.sixpackcompose.ui.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.mafredri.sixpackcompose.ui.BottomBarItem
import no.uio.ifi.in2000.mafredri.sixpackcompose.ui.exercise.ExerciseScreen
import no.uio.ifi.in2000.mafredri.sixpackcompose.ui.exercise.ExerciseViewModel
import no.uio.ifi.in2000.mafredri.sixpackcompose.ui.workout.WorkoutScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomAppNavigator() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) {
        NavHost(navController, startDestination = BottomBarItem.Home.route) {
            composable(BottomBarItem.Home.route) { HomeScreen() }
            composable(BottomBarItem.CreateWorkout.route) { WorkoutScreen() }
            composable(BottomBarItem.CreateExcercise.route) { ExerciseScreen() }
        }
    }
}