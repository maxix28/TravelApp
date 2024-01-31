package com.example.travelapp.ui.navigation

interface NavigatioDistination {
    val route : String
}


sealed class Destination{
    object Login:NavigatioDistination{
        override val route: String
            get() = "Login_Screen"
    }
    object MainScreen:NavigatioDistination{
        override val route: String
            get() = "MainScreen"
    }
    object BusRoutes:NavigatioDistination{
        override val route: String
            get() = "Bus_routes"
    }
    object OrderingTicket:NavigatioDistination{
        override val route: String
            get() = "OrderTicket_Screen"
    }
    object MyTicket:NavigatioDistination{
        override val route: String
            get() = "My_Ticket"
    }
    object PastTicket:NavigatioDistination{
        override val route: String
            get() = "Past_Ticket"
    }
    object Account:NavigatioDistination{
        override val route: String
            get() = "Account_Screen"
    }




}
