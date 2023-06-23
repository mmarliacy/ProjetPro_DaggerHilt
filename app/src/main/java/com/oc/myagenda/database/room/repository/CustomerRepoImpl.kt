package com.oc.myagenda.database.room.repository

import com.oc.myagenda.database.entities.Customer
import com.oc.myagenda.database.room.DAO.CustomerDao
import com.oc.myagenda.database.room.repository.requests.CustomerRepository
import kotlinx.coroutines.flow.Flow

class CustomerRepoImpl(private val customerDao: CustomerDao): CustomerRepository {

    override suspend fun insertCustomer(customer: Customer) {
        customerDao.insertCustomer(customer)
    }

    override suspend fun deleteCustomer(customer: Customer) {
        customerDao.deleteCustomer(customer)
    }

    override fun getCustomers(): Flow<List<Customer>> {
        return customerDao.getCustomers()
    }
}