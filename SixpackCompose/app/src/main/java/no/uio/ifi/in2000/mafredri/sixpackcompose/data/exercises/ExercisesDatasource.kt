package no.uio.ifi.in2000.mafredri.sixpackcompose.data.exercises

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.mafredri.sixpackcompose.data.ApiClient
import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercise
import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercises


class ExercisesDatasource() {
    private val url = "https://localhost:3000/"

    fun fetchExercises(): MutableList<Exercise> {
        val exercises: Exercises
        runBlocking {
            val httpResponse = ApiClient.client.get(url)
            exercises = httpResponse.body()
        }
        return exercises.exercises.toMutableList()
    }
}