package com.oc.myagenda.utils.events

import com.oc.myagenda.database.entities.Customer

interface CustomerListEvent {
    fun onCustomerClick(customer: Customer)
    fun onAddCustomerClick(customer : Customer)


    //data class DeleteCustomer(val customer: Customer) : CustomerListEvent()
    //data class UndoDeleteCustomer(val customer: Customer) : CustomerListEvent()
    //data class UpdateCustomer(val customer: Customer, val route : String, val isDone : Boolean): CustomerListEvent()
    //data class UpdateCustomerList(val customerList: ArrayList<Customer>) : CustomerListEvent()
}
