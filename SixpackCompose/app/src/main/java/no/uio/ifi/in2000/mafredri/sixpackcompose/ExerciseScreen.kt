package no.uio.ifi.in2000.mafredri.sixpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times

@Composable
fun ExerciseScreen() {
    var excerciseName by remember { mutableStateOf("") }
    var excerciseDesc by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf("") }
    val excercises: MutableList<Excercise> = mutableListOf(Excercise("Bench press", "Dytt benk sjamener"), Excercise("Squat", "Vekt på skuldra og bøy knærne"))
    val focusManager = LocalFocusManager.current

    repeat(20) {
        excercises.add(Excercise("Bench press$it", "Dytt benk sjamener"))
    }

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
                    value = excerciseName,
                    onValueChange = { excerciseName = it },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    label = { Text(text = "Excercise name") },
                )
                OutlinedTextField(
                    value = excerciseDesc,
                    onValueChange = { excerciseDesc = it },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    label = { Text(text = "Excercise description") }
                )

            }
            Column {
                Button(
                    onClick = {
                        excercises.add(Excercise(excerciseName, excerciseDesc))
                        focusManager.clearFocus()
                        errorMsg = if (excerciseName.isBlank()) {
                            "Excersice requires a name"
                        } else {
                            ""
                        }
                        excerciseName = ""
                        excerciseDesc = ""
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .height(IntrinsicSize.Max),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(text = "Add excercise", fontSize = 10.sp)
                }
                Text(
                    text = errorMsg,
                    color = Color.Red
                    )
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
                .height((excercises.size + 1) * 58.dp)
        ) {
            excercises.forEach {excercise ->
                Box(
                    modifier = Modifier

                        .padding(bottom = 4.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xffd9d9d9))

                ) {
                    Column(
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Text(
                            text = excercise.name,
                            fontSize = 16.sp
                        )
                        Text(
                            text = excercise.desc,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}