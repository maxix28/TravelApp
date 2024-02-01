package com.example.travelapp.localdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SavedTickets")
data class TicketD(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var start: String,
    var finish: String,
    var Name: String,
    var SecondName: String,
    var phone: String
)
