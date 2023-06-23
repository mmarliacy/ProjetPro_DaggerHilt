package com.oc.myagenda.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oc.myagenda.database.entities.Customer
import com.oc.myagenda.database.room.repository.requests.AppointmentRepository
import com.oc.myagenda.database.room.repository.requests.CustomerRepository
import com.oc.myagenda.database.room.repository.requests.SectionRepository
import com.oc.myagenda.database.room.repository.requests.ServiceRepository
import com.oc.myagenda.utils.events.CustomerListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appointmentRepository: AppointmentRepository,
    private val customerRepository: CustomerRepository,
    private val sectionRepository: SectionRepository,
    private val serviceRepository: ServiceRepository
): ViewModel() {


    //--> CUSTOMERS

    fun insertCustomer(customer: Customer) = CoroutineScope(Dispatchers.Main).launch {
        customerRepository.insertCustomer(customer)
    }

    fun getCustomers() = customerRepository.getCustomers()
}