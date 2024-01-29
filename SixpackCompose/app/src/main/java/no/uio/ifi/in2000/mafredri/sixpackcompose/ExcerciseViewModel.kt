package no.uio.ifi.in2000.mafredri.sixpackcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ExercisesUIState(
    val exercises: MutableList<Exercise> = mutableListOf() // TODO: legg til noe som henter fra databasen
)

class ExerciseViewModel: ViewModel() {
    private val _exercisesUIState = MutableStateFlow(ExercisesUIState())
    val exercisesUiState: StateFlow<ExercisesUIState> = _exercisesUIState.asStateFlow()

    fun add(newExercise: Exercise) {
        viewModelScope.launch {
            _exercisesUIState.value.exercises.add(newExercise)
            _exercisesUIState.update {
                it.copy(

                )
            }
        }
    }
}