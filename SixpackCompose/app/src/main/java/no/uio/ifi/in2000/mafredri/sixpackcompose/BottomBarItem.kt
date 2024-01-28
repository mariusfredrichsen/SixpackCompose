package no.uio.ifi.in2000.mafredri.sixpackcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(val route: String, val urlIcon: String, val label: String) {
    object Home : BottomBarItem("home", "https://raw.githubusercontent.com/mariusfredrichsen/SixpackCompose/main/images/home.png", "Home")
    object CreateWorkout : BottomBarItem("workout", "https://raw.githubusercontent.com/mariusfredrichsen/SixpackCompose/main/images/create.png", "Create Workout")
    object CreateExcercise : BottomBarItem("exercise", "https://raw.githubusercontent.com/mariusfredrichsen/SixpackCompose/main/images/add.png", "Create Exercise")
}