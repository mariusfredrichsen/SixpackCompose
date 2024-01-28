package no.uio.ifi.in2000.mafredri.sixpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.mafredri.sixpackcompose.ui.theme.SixpackComposeTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.ServerApi
import com.mongodb.ServerApiVersion
import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.runBlocking
import org.bson.Document


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "AuthLeak")
    override fun onCreate(savedInstanceState: Bundle?) {

        val connectionString = "mongodb+srv://marius:@discord.7b4in8d.mongodb.net/?retryWrites=true&w=majority"
        val serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build()

        super.onCreate(savedInstanceState)
        setContent {
            SixpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = { BottomBar(navController) }
                    ) {
                        NavHost(navController, startDestination = BottomBarItem.Home.route) {
                            composable(BottomBarItem.Home.route) { HomeScreen() }
                            composable(BottomBarItem.CreateWorkout.route) { WorkoutScreen() }
                            composable(BottomBarItem.CreateExcercise.route) { ExerciseScreen() }
                        }
                    }
                }
            }
        }
    }
}

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






















