package no.uio.ifi.in2000.mafredri.sixpackcompose.model

data class Exercises(val exercises: List<Exercise>)

data class Exercise(val name: String, val desc: String)
