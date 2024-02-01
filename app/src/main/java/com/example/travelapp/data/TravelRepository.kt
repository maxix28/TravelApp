package com.example.travelapp.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.travelapp.localdatabase.TicketD
import kotlinx.coroutines.flow.Flow

interface TravelRepository {
    suspend fun SaveTicket(ticket: TicketD)

    suspend fun DeleteTicket(ticket: TicketD)

    fun getAllTickets(): Flow<TicketD>
}



