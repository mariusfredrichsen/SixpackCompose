package no.uio.ifi.in2000.mafredri.sixpackcompose.ui.exercise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteExerciseDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    exerciseName: String
    ) {
        AlertDialog(
            onDismissRequest = {  }
        ) {
            Card() {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(text = "Delete exercise?", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Are you sure you want to delete the '$exerciseName' exercise?")
                    Row {
                        TextButton(onClick = { onDismissRequest() }) {
                            Text(text = "Dismiss")
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        TextButton(onClick = { onConfirmation() }) {
                            Text(text = "Confirm")
                        }
                    }
                }
            }
        }
}