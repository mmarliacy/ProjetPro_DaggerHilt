package com.oc.myagenda.mvvm.room.repository.interfaces
import com.oc.myagenda.model.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {

    suspend fun insertCustomer(customer: Customer)

    suspend fun deleteCustomer(customer: Customer)

    fun getCustomers() : Flow<List<Customer>>
}