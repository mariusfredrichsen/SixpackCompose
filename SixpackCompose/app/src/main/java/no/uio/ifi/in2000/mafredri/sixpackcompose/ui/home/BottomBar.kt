package no.uio.ifi.in2000.mafredri.sixpackcompose.ui.home

import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import no.uio.ifi.in2000.mafredri.sixpackcompose.ui.BottomBarItem


@Composable
fun BottomBar(navController: NavController) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar(
        contentColor = Color(0xFFFFE0B2),
        containerColor = Color(0xFFFFB74D)
    ) {
        listOf(BottomBarItem.Home, BottomBarItem.CreateWorkout, BottomBarItem.CreateExcercise).forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { selectedItem = index; navController.navigate(item.route) },
                icon = {
                    AsyncImage(model = item.urlIcon, contentDescription = null, modifier = Modifier.size(25.dp))
                },
                label = { Text(text = item.label) }
            )
        }
    }
}

