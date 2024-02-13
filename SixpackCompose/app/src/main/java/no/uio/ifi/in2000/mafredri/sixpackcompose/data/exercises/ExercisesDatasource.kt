package no.uio.ifi.in2000.mafredri.sixpackcompose.data.exercises

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.mafredri.sixpackcompose.data.ApiClient
import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercise
import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercises


class ExercisesDatasource() {
    private val url = "http://129.151.216.198:3000/"

    fun fetchExercises(): MutableList<Exercise> {
        return try {
            runBlocking {
                val exercises: Exercises = ApiClient.client.get(url).body()
                exercises.exercises.toMutableList()
            }
        } catch (e: Exception) {
            println("HHJEEEEELPPP")
            mutableListOf()
        }
    }
}