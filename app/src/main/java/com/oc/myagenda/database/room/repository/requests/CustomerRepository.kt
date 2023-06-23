package com.oc.myagenda.database.room.repository.requests
import com.oc.myagenda.database.entities.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {

    suspend fun insertCustomer(customer: Customer)

    suspend fun deleteCustomer(customer: Customer)

    fun getCustomers() : Flow<List<Customer>>
}