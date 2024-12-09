package com.krishnajeena.studybuddy

import android.credentials.CredentialManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.krishnajeena.studybuddy.auth.MainAuthenticationScreen
import com.krishnajeena.studybuddy.ui.theme.StudyBuddyTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            StudyBuddyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    MainAuthenticationScreen()
                }
            }
        }
    }
}