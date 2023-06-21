package com.oc.myagenda.util

import com.oc.myagenda.model.Customer

sealed class CustomerListEvent{
    data class UpdateCustomerList(val customerList: ArrayList<Customer>) : CustomerListEvent()
    data class DeleteCustomer(val customer: Customer) : CustomerListEvent()
    data class UpdateCustomer(val customer: Customer, val route : String): CustomerListEvent()
    data class OnCustomerClick(val customer: Customer): CustomerListEvent()
    object OnAddCustomerClick: CustomerListEvent()
}
