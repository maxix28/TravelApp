package com.example.travelapp.utilities

import android.app.appsearch.AppSearchManager.SearchContext
import androidx.room.Entity
import java.util.Date


data class Ticket (

    var start :String,
    var finish :String,
    var Name :String,
    var Secondname :String,
    var phone :String,
    var date: Date

    )

