package no.uio.ifi.in2000.mafredri.sixpackcompose.ui.exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Exercise

@Composable
fun ExerciseScreen(exerciseViewModel: ExerciseViewModel = viewModel()) {
    val exercisesUIState by exerciseViewModel.exercisesUIState.collectAsState()

    var exerciseName by remember { mutableStateOf("") }
    var exerciseDesc by remember { mutableStateOf("") }

    var errorColor by remember { mutableStateOf(Color.DarkGray) }
    val exercisesUI by exerciseViewModel.exercisesUIState.collectAsState()
    val state = rememberUpdatedState(exercisesUI.exercises)

    val focusManager = LocalFocusManager.current

    var showAlertDialog by remember { mutableStateOf(false) }
    var exerciseAlertDialog: Exercise? by remember { mutableStateOf(null) }

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
            modifier = Modifier
                .height(440.dp)
        ) {
            items(exercisesUIState.exercises) { exercise ->
                Row(
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .clip(RoundedCornerShape(10))
                        .background(Color(0xffd9d9d9)),

                ) {
                    Column(
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Row {
                            Text(
                                text = exercise.name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Icon(
                                imageVector = Icons.Filled.Create,
                                contentDescription = null,
                            )
                        }
                        BasicText(
                            text = exercise.desc,
                            modifier = Modifier
                                .width(340.dp)

                        )
                    }
                    IconButton(
                        onClick = { showAlertDialog = true; exerciseAlertDialog = exercise },
                        modifier = Modifier
                            .size(80.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = null, modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
        if (showAlertDialog && (exerciseAlertDialog != null)) {
            DeleteExerciseDialog(
                { showAlertDialog = false },
                { exerciseViewModel.removeExercise(exerciseAlertDialog!!); showAlertDialog = false },
                exerciseAlertDialog!!.name
            )
        }
    }
}