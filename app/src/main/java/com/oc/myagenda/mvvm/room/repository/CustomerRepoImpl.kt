package com.oc.myagenda.mvvm.room.repository

import com.oc.myagenda.model.Customer
import com.oc.myagenda.mvvm.room.database.DAO.CustomerDao
import com.oc.myagenda.mvvm.room.repository.interfaces.CustomerRepository
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