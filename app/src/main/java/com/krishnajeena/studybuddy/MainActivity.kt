package com.krishnajeena.studybuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.krishnajeena.studybuddy.auth.MainAuthenticationScreen
import com.krishnajeena.studybuddy.screens.HomeScreen
import com.krishnajeena.studybuddy.ui.theme.StudyBuddyTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            StudyBuddyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    var screen by remember { mutableStateOf("authScreen") }

                    val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
                    if (user != null) {
                        screen = "homeScreen"
                    }

                    NavHost(navController = navController, screen){

                        composable("authScreen"){
                            MainAuthenticationScreen(navController = navController)
                        }
                            composable("homeScreen") {
                                HomeScreen(navController = navController)
                            }
                    }

                }
            }
        }
    }
}