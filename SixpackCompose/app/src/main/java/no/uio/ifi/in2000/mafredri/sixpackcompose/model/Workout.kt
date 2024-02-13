package no.uio.ifi.in2000.mafredri.sixpackcompose.model

import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercise

data class Workout(val name: String) {
    val exercises: MutableList<Exercise> = mutableListOf()
}