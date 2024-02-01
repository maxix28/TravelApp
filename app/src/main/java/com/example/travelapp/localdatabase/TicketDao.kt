package com.example.travelapp.localdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.travelapp.utilities.Ticket
import kotlinx.coroutines.flow.Flow

@Dao
interface TicketDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun SaveTicket(ticket: TicketD)

    @Delete
    suspend fun DeleteTicket(ticket: TicketD)

    @Query("select * from SavedTickets")
    fun getAllTickets(): Flow<List<TicketD>>

}