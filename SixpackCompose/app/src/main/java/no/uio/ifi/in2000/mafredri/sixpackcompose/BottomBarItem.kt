package no.uio.ifi.in2000.mafredri.sixpackcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(val route: String, val urlIcon: String, val label: String) {
    object Home : BottomBarItem("home", "https://github.com/mariusfredrichsen/egen/tree/main/SixpackCompose/images/home.png", "Home")
    object Workouts : BottomBarItem("workouts", "https://github.com/mariusfredrichsen/egen/tree/main/SixpackCompose/images/create.png", "Workouts")
    object CreateWorkout : BottomBarItem("excersice", "https://github.com/mariusfredrichsen/egen/blob/main/SixpackCompose/images/add.png", "CreateWorkout")
}