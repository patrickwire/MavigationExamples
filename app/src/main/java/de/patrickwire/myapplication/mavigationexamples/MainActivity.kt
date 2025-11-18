package de.patrickwire.myapplication.mavigationexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import de.patrickwire.myapplication.mavigationexamples.navigation.AppNavigation
import de.patrickwire.myapplication.mavigationexamples.ui.theme.MavigationExamplesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MavigationExamplesTheme {
                AppNavigation()
            }
        }
    }
}
