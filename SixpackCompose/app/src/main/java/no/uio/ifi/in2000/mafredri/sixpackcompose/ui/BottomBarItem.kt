package no.uio.ifi.in2000.mafredri.sixpackcompose.ui

sealed class BottomBarItem(val route: String, val urlIcon: String, val label: String) {
    object Home : BottomBarItem("home", "https://raw.githubusercontent.com/mariusfredrichsen/SixpackCompose/main/images/home.png", "Home")
    object CreateWorkout : BottomBarItem("workout", "https://raw.githubusercontent.com/mariusfredrichsen/SixpackCompose/main/images/create.png", "Create Workout")
    object CreateExcercise : BottomBarItem("exercise", "https://raw.githubusercontent.com/mariusfredrichsen/SixpackCompose/main/images/add.png", "Create Exercise")
}