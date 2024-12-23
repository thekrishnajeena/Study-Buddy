package com.krishnajeena.studybuddy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.krishnajeena.studybuddy.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = HomeViewModel(),
    navController: NavHostController
) {

    val name = viewModel.userData.observeAsState()

    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally){

            name.value?.name?.let { Text(text = it, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 24.sp) }

        }
    }

}