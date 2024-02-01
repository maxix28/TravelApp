package com.example.travelapp.di.modules

import android.app.Application
import com.example.travelapp.data.DefaultTravelRepository
import com.example.travelapp.data.TravelRepository
import com.example.travelapp.localdatabase.TicketDao
import com.example.travelapp.localdatabase.TicketDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DefaultModules{

    @Provides
    fun provideTicketDao(app:Application):TicketDao{
        return TicketDatabase.getDataBase(app).ticketDao()
    }

    @Provides
    fun provideTravelRepository(ticketDao: TicketDao):TravelRepository{
        return DefaultTravelRepository(ticketDao)
    }
}