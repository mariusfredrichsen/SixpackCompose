package no.uio.ifi.in2000.mafredri.sixpackcompose.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import no.uio.ifi.in2000.mafredri.sixpackcompose.model.Workout

@Composable
fun HomeScreen() {
    val testList = listOf(Workout("Pull1"), Workout("Pull2"), Workout("Push1"), Workout("Push2"), Workout("Legs1"), Workout("Legs2"))
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .height((testList.size*110+300).dp)
    ) {
        Text(
            text = "Current workout",
            fontSize = 32.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xffd9d9d9))
                .clickable { },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Click to start a workout",
                modifier = Modifier.padding(8.dp)
            )
        }

        Text(
            text = "Workout history",
            fontSize = 32.sp,
            modifier = Modifier
                .padding(top = 20.dp)
        )

        testList.forEach {workout ->
            Row(
                modifier = Modifier.padding(top = 12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xffd9d9d9))
                        .clickable { }
                ) {
                    Text(
                        text = workout.name,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}