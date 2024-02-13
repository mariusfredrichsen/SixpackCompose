package no.uio.ifi.in2000.mafredri.sixpackcompose.data.exercises

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercise

class ExercisesRepository {
    val exercisesDatasource = ExercisesDatasource()

    private val _exercises = MutableStateFlow<MutableList<Exercise>>(mutableListOf())

    fun loadExercises(): StateFlow<MutableList<Exercise>> = _exercises.asStateFlow()

    suspend fun fetchExercises() {
        _exercises.update {
            exercisesDatasource.fetchExercises()
        }
    }

    suspend fun addExercise(newExercise: Exercise) {
        _exercises.update { exercises ->
            exercises.plus(newExercise).toMutableList()
        }
    }

    suspend fun removeExercise(oldExercise: Exercise) {
        _exercises.update { exercises ->
            exercises.minus(oldExercise).toMutableList()
        }
    }
}