package com.oc.myagenda.util

sealed class CustomerUiEvent{

    // Events on Customer Frag
    data class HandleBottomNavPosition(val position : Int) :
            CustomerUiEvent()

    data class Navigate(val route : String) : CustomerUiEvent()

}
