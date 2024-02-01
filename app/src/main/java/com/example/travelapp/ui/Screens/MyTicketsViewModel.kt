package com.example.travelapp.ui.Screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelapp.data.TravelRepository
import com.example.travelapp.localdatabase.TicketD
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


sealed interface TicketUIState{
    object Loading: TicketUIState
    object Error: TicketUIState, StateFlow<TicketUIState> {
        override val replayCache: List<TicketUIState>
            get() = TODO("Not yet implemented")

        override suspend fun collect(collector: FlowCollector<TicketUIState>): Nothing {
            TODO("Not yet implemented")
        }

        override val value: TicketUIState
            get() = TODO("Not yet implemented")
    }

    data class Success(val tickets: List<TicketD>): TicketUIState

}


@HiltViewModel
class MyTicketsViewModel @Inject constructor(private  val travelRepository: TravelRepository):ViewModel(){


   // var UIState: TicketUIState by mutableStateOf(TicketUIState.Loading )

    val UIState : StateFlow<TicketUIState> =
        try{travelRepository.getAllTickets().map{ TicketUIState.Success(it)}
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = TicketUIState.Loading
            )}
        catch (
            e:Exception
        ){
            TicketUIState.Error
        }
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L

    }

    }