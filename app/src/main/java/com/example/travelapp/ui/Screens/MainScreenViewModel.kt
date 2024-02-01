package com.example.travelapp.ui.Screens

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.travelapp.data.TravelRepository
import com.example.travelapp.localdatabase.TicketD
import com.example.travelapp.utilities.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


data class MainUIState(
    var startDestination: String = "",
    var finalDestination: String = "",
    var showUserInfo: Boolean = false
) {
    fun toTicketD(): TicketD = TicketD(
        start = startDestination,
        finish = finalDestination,
        Name = User.name.toString(),
        SecondName = User.secondName.toString(),
        phone = User.phoneNumber.toString()
    )
}

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val travelRepository: TravelRepository) :
    ViewModel() {
    private var _UiState = MutableStateFlow(MainUIState())
    val UiState = _UiState.asStateFlow()

    fun setStartLocation(Location: String) {
        _UiState.update {
            it.copy(startDestination = Location)
        }
    }

    suspend fun saveTicket() = travelRepository.SaveTicket(UiState.value.toTicketD())
    fun setFinalLocation(Location: String) {
        _UiState.update {
            it.copy(finalDestination = Location)
        }
        // Log.d("MAin",UiState.value.showUserInfo.toString())

    }

    fun setInfo() {
        _UiState.update {
            it.copy(showUserInfo = !it.showUserInfo)
        }
        //   Log.d("MAin",UiState.value.showUserInfo.toString())
    }
}