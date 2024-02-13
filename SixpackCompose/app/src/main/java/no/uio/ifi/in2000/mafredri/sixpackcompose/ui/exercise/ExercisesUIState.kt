package no.uio.ifi.in2000.mafredri.sixpackcompose.ui.exercise

import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercise

data class ExercisesUIState(
    val exercises: MutableList<Exercise> = mutableListOf()
)