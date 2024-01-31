package com.example.travelapp.ui.Screens

import androidx.lifecycle.ViewModel
import java.lang.Error

data class LoginState(
     var isSuccessful:Boolean= false,
    var error: String?= null
)

class LoginViewModel:ViewModel() {

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

}