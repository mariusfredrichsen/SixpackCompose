package no.uio.ifi.in2000.mafredri.sixpackcompose.ui.exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.mafredri.sixpackcompose.data.exercises.ExercisesRepository
import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercise

class ExerciseViewModel: ViewModel() {
    private val exercisesRepository = ExercisesRepository()

    val exercisesUIState = exercisesRepository.loadExercises()
        .map { ExercisesUIState(exercises = it) }
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ExercisesUIState()
        )

    fun addExercise(newExercise: Exercise) {
        viewModelScope.launch {
            exercisesRepository.addExercise(newExercise)
        }
    }

    fun removeExercise(oldExercise: Exercise) {
        viewModelScope.launch {
            exercisesRepository.removeExercise(oldExercise)
        }
    }

    init {
        viewModelScope.launch {
            exercisesRepository.fetchExercises()
        }
    }
}