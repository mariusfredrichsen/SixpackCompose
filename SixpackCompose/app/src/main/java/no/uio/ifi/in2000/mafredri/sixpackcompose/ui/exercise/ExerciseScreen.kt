package no.uio.ifi.in2000.mafredri.sixpackcompose.ui.exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercise

@Composable
fun ExerciseScreen(exerciseViewModel: ExerciseViewModel = viewModel()) {
    val exercisesUIState by exerciseViewModel.exercisesUIState.collectAsState()

    var exerciseName by remember { mutableStateOf("") }
    var exerciseDesc by remember { mutableStateOf("") }

    var errorColor by remember { mutableStateOf(Color.DarkGray) }
<<<<<<< HEAD:SixpackCompose/app/src/main/java/no/uio/ifi/in2000/mafredri/sixpackcompose/ExerciseScreen.kt
    val exercisesUI by exerciseViewModel.exercisesUiState.collectAsState()
    val state = rememberUpdatedState(exercisesUI.exercises)
=======

>>>>>>> 31641bcfdb5df1a2a01e39429b802061c92eab4d:SixpackCompose/app/src/main/java/no/uio/ifi/in2000/mafredri/sixpackcompose/ui/exercise/ExerciseScreen.kt
    val focusManager = LocalFocusManager.current

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(8.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        Text(
            text = "Create excercise",
            fontSize = 32.sp
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                OutlinedTextField(
                    value = exerciseName,
                    onValueChange = { exerciseName = it },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    label = { Text(text = "Excercise name", color = errorColor) },
                )
                OutlinedTextField(
                    value = exerciseDesc,
                    onValueChange = { exerciseDesc = it },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    label = { Text(text = "Excercise description") }
                )

            }
            Column {
                Button(
                    onClick = {

                        focusManager.clearFocus()
                        if (exerciseName.isBlank()) {
                            errorColor = Color.Red
                        } else {
                            errorColor = Color.DarkGray
                            exerciseViewModel.addExercise(Exercise(exerciseName, exerciseDesc))
                            exerciseName = ""
                            exerciseDesc = ""
                        }
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .height(IntrinsicSize.Max),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Text(text = "Add")
                }
            }
        }
        Text(
            text = "Excercises",
            fontSize = 32.sp,
            modifier = Modifier
                .padding(top = 12.dp, bottom = 8.dp)
        )
        LazyColumn(
        ) {
<<<<<<< HEAD:SixpackCompose/app/src/main/java/no/uio/ifi/in2000/mafredri/sixpackcompose/ExerciseScreen.kt
            itemsIndexed(state.value) { index, exercise ->
=======
            items(exercisesUIState.exercises) { exercise ->
>>>>>>> 31641bcfdb5df1a2a01e39429b802061c92eab4d:SixpackCompose/app/src/main/java/no/uio/ifi/in2000/mafredri/sixpackcompose/ui/exercise/ExerciseScreen.kt
                Row(
                    modifier = Modifier

                        .padding(bottom = 4.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xffd9d9d9)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text(
                            text = exercise.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = exercise.desc + "\n${exercisesUIState.exercises.size}",
                            fontSize = 12.sp,
                            lineHeight = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))

                    AsyncImage(
                        model = "https://raw.githubusercontent.com/mariusfredrichsen/SixpackCompose/main/images/delete.png",
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                exerciseViewModel.removeExercise(exercise)

                            }
                    )

                    Spacer(modifier = Modifier.padding(4.dp))
                }
            }
        }
    }
}