package no.uio.ifi.in2000.mafredri.sixpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.unit.times
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun ExerciseScreen(exerciseViewModel: ExerciseViewModel = viewModel()) {
    var exerciseName by remember { mutableStateOf("") }
    var exerciseDesc by remember { mutableStateOf("") }
    var errorColor by remember { mutableStateOf(Color.DarkGray) }
    val exercisesUI by exerciseViewModel.exercisesUiState.collectAsState()
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
                            exerciseViewModel.add(Exercise(exerciseName, exerciseDesc))
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
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .height((exercisesUI.exercises.size + 1) * 58.dp)
        ) {
            exercisesUI.exercises.forEach { exercise ->
                Box(
                    modifier = Modifier

                        .padding(bottom = 4.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xffd9d9d9))

                ) {
                    Row(
                        
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
                                text = exercise.desc,
                                fontSize = 12.sp,
                                lineHeight = 14.sp
                            )
                        }
                        AsyncImage(model = , contentDescription = )
                    }
                }
            }
        }
    }
}