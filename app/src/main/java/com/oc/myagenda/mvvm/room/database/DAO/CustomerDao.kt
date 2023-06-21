package com.oc.myagenda.mvvm.room.database.DAO

import androidx.room.*
import com.oc.myagenda.model.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer)

    @Delete
    suspend fun deleteCustomer(customer: Customer)

    @Query("SELECT * FROM customer_table")
    fun getCustomers() : Flow<List<Customer>>
}