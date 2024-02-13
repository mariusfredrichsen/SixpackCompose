package no.uio.ifi.in2000.mafredri.sixpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import no.uio.ifi.in2000.mafredri.sixpackcompose.ui.home.BottomAppNavigator
import no.uio.ifi.in2000.mafredri.sixpackcompose.ui.theme.SixpackComposeTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "AuthLeak")
    override fun onCreate(savedInstanceState: Bundle?) {
<<<<<<< HEAD

        /*val connectionString = "mongodb+srv://marius:po2XxJKx9NQC7P4U@discord.7b4in8d.mongodb.net/"
        val mongoClient = MongoClient.create(connectionString)
        val database = mongoClient.getDatabase("SixpackCompose")
        println(database.name) */

=======
>>>>>>> 31641bcfdb5df1a2a01e39429b802061c92eab4d
        super.onCreate(savedInstanceState)
        setContent {
            SixpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BottomAppNavigator()
                }
            }
        }
    }
}






















