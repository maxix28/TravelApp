package com.example.travelapp.ui.Screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.ui.navigation.Destination
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text

@Composable
fun MyTickets(
    ticketsViewModel: MyTicketsViewModel = hiltViewModel<MyTicketsViewModel>(),
    modifier: Modifier = Modifier
) {
val UiState = ticketsViewModel.UIState.collectAsState()
    when(UiState.value) {
        TicketUIState.Error -> {}
        TicketUIState.Loading -> {
            CircularProgressIndicator()
        }
        is TicketUIState.Success -> {
            LazyColumn(modifier = modifier.fillMaxSize()){
               items((UiState.value as TicketUIState.Success).tickets){
                   Text(it.toString())
               }



            }
    }

    }
}