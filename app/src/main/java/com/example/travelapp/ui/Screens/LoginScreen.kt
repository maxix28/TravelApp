package com.example.travelapp.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.Greeting
import com.example.travelapp.R
import com.example.travelapp.ui.theme.TravelAppTheme


@Composable
fun LoginScreen(modifier: Modifier = Modifier, onSuccessLogin:()->Unit) {
//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // App Logo or Image
        Column {
            Image(
                painter = painterResource(id = R.drawable.baseline_mode_of_travel_24),
                contentDescription = "App Logo"
                ,
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Username TextField
//        OutlinedTextField(
//            value = username,
//            onValueChange = { username = it },
//            placeholder = { Text("Username") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            singleLine = true,
//            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) }
//        )
                Text(
                    text = "TravelApp",
                    modifier = modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp
                    //fontWeight = MaterialTheme.typography.titleLarge
                )
        }
        Spacer(modifier = Modifier.height(16.dp))

//        // Password TextField
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            placeholder = { Text("Password") },
//            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
//            trailingIcon = {
//                IconButton(
//                    onClick = { isPasswordVisible = !isPasswordVisible },
//                    modifier = Modifier
//                        .clickable { }
//                        .padding(4.dp)
//                ) {
//                    Icon(
//                        imageVector = if (isPasswordVisible) Icons.Default.Done else Icons.Default.Clear,
//                        contentDescription = if (isPasswordVisible) "Hide Password" else "Show Password"
//                    )
//                }
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Password,
//                imeAction = ImeAction.Done
//            ),
//            keyboardActions = KeyboardActions(
//                onDone = { /* Handle login logic here */ }
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) }
//        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick =  onSuccessLogin ,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Login via Google ")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview() {
    //LoginScreen()
    TravelAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(onSuccessLogin = {})
        }
    }
}