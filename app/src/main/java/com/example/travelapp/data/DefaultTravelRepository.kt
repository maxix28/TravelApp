package com.example.travelapp.data

import com.example.travelapp.localdatabase.TicketD
import com.example.travelapp.localdatabase.TicketDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultTravelRepository  @Inject constructor(private val ticketDao: TicketDao):TravelRepository {
    override suspend fun SaveTicket(ticket: TicketD) = ticketDao.SaveTicket(ticket)

    override suspend fun DeleteTicket(ticket: TicketD) = ticketDao.DeleteTicket(ticket)
    override fun getAllTickets(): Flow<List<TicketD>> = ticketDao.getAllTickets()
}