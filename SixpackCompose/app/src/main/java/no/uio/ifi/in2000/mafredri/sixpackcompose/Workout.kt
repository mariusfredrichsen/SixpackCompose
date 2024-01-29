package no.uio.ifi.in2000.mafredri.sixpackcompose

data class Workout(val name: String) {
    val exercises: MutableList<Excercise> = mutableListOf()
}