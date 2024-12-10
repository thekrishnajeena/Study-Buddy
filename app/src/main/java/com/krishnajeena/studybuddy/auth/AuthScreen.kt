package com.krishnajeena.studybuddy.auth

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.krishnajeena.studybuddy.R
import kotlinx.coroutines.CoroutineScope


@Composable
fun MainAuthenticationScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        GoogleSignInUtils.doGoogleSignIn(
            context = context,
            scope = scope,
            launcher = null,
            login = {
                Toast.makeText(context, "Login", Toast.LENGTH_LONG).show()

            }
        )
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

    Column(modifier = Modifier.padding(start=10.dp, end=10.dp,
        top = 10.dp, bottom = 60.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Row(modifier = Modifier.fillMaxWidth().padding(10.dp).align(Alignment.CenterHorizontally)) {
            Text(
                text = "Sign Up", fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp, modifier = Modifier.padding(bottom = 30.dp)
            )
        }
        OutlinedTextField(
            placeholder = { Text("Name") },
            value = "", onValueChange = {},
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        )

        OutlinedTextField(
            placeholder = { Text("Email") },
            value = "", onValueChange = {},
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        )

        OutlinedTextField(
            placeholder = { Text("Create Password") },
            value = "", onValueChange = {},
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        )

        Button(onClick = {}, shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(10.dp),

            ) {
            Text("Sign Up")
        }

        Text(
            "By Signing up, you agree to \nour Terms of Service and Privacy Policy",
            modifier = Modifier.padding(5.dp).wrapContentWidth(), minLines = 1,
            textAlign = TextAlign.Center, fontSize = 12.sp, color = Color.Gray
        )

        Text(
            "Or",
            modifier = Modifier.padding(10.dp).wrapContentWidth(), minLines = 1,
            textAlign = TextAlign.Center, fontSize = 12.sp, color = Color.Gray
        )



        IconButton(
            onClick = {
                GoogleSignInUtils.doGoogleSignIn(
                    context = context,
                    scope = scope,
                    launcher = launcher,
                    login = {
                        Toast.makeText(context, "Login", Toast.LENGTH_LONG).show()
                    }
                )
            },
            modifier = Modifier.padding(bottom = 10.dp)
                .shadow(10.dp, shape = androidx.compose.foundation.shape.CircleShape)
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google), contentDescription = null,
                modifier = Modifier.padding(6.dp)
            )
        }

    }

        Row(modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            Text("Already have an account?", modifier = Modifier.padding(end=4.dp))
            Text("Login", fontWeight = FontWeight.SemiBold)
        }
    }



}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainAuthenticationScreenPreview(){
    MainAuthenticationScreen()

}