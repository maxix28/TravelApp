package com.example.travelapp.localdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(TicketD::class), version = 2)
abstract  class TicketDatabase :RoomDatabase(){


    abstract fun ticketDao():TicketDao

    companion object{

        @Volatile
        private var Instance:TicketDatabase?= null

        fun getDataBase( context: Context): TicketDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TicketDatabase::class.java, "app_database")

                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }

        }


    }
}