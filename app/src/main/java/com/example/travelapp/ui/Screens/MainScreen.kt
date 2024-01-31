package com.example.travelapp.ui.Screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.ui.navigation.Destination
import com.example.travelapp.ui.theme.TravelAppTheme
import com.example.travelapp.utilities.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainScreenViewModel = hiltViewModel<MainScreenViewModel>()
) {
    var UIState = mainViewModel.UiState.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondaryContainer)

            //.background(MaterialTheme.colorScheme.secondaryContainer),


        ) { paddingValues ->
            Column {
                topBar(
                    modifier = modifier.padding(paddingValues),
                    onIconClick = {mainViewModel.setInfo()}

                    ,
                    show = UIState.value.showUserInfo)
                Spacer(modifier = modifier.height(20.dp))
                SearchPart(
                    modifier = modifier.padding(paddingValues),
                    start = UIState.value.startDestination,
                    finish = UIState.value.finalDestination,
                    onStartChange = { mainViewModel.setStartLocation(it) },
                    onFinishChange = { mainViewModel.setFinalLocation(it) }
                )
            }

        }
    }
}

@Composable
fun topBar(modifier: Modifier = Modifier, onIconClick: () -> Unit, show: Boolean) {

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            modifier = modifier
                .padding(15.dp)
                //  .clip(RoundedCornerShape(10.dp))
                // .background(MaterialTheme.colorScheme.tertiaryContainer)
                //.border(5.dp, color = MaterialTheme.colorScheme.secondaryContainer)

                .animateContentSize()
                .clickable ( onClick =  onIconClick ),

            ) {

            Column {
                Row(modifier = modifier, horizontalArrangement = Arrangement.End) {

                    Icon(imageVector = Icons.Default.Person, contentDescription = "userPhoto")
                }
                if (show) {
//                Text(
//                    text = "Travel app",
//                    modifier = modifier
//                        .padding(20.dp)
//                )
                    Text(
                        text = "Welcome ${User.name} ${User.secondName}",
                        modifier = modifier
                            .padding(20.dp)
                    )
                }

            }


        }
    }

}


@Composable
fun SearchPart(
    modifier: Modifier = Modifier,
    start: String,
    finish: String,
    onStartChange: (String) -> Unit,
    onFinishChange: (String) -> Unit,
) {


    //var UIState = mainViewModel.UiState.collectAsState()
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = start,
            onValueChange = { onStartChange(it) },
            placeholder = { Text("From") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) }
        )

        OutlinedTextField(
            value = finish,
            onValueChange = { onFinishChange(it) },
            placeholder = { Text("To") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) }
        )
    }

}

@Preview
@Composable
fun Preview() {
    TravelAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {
            MainScreen(
                modifier = Modifier
                // .background(MaterialTheme.colorScheme.secondaryContainer)
            )
        }
    }
}