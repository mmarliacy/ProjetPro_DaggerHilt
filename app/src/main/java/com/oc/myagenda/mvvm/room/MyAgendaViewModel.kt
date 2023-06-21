package com.oc.myagenda.mvvm.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oc.myagenda.mvvm.room.repository.interfaces.AppointmentRepository
import com.oc.myagenda.mvvm.room.repository.interfaces.CustomerRepository
import com.oc.myagenda.mvvm.room.repository.interfaces.SectionRepository
import com.oc.myagenda.mvvm.room.repository.interfaces.ServiceRepository
import com.oc.myagenda.util.CustomerListEvent
import com.oc.myagenda.util.CustomerUiEvent
import com.oc.myagenda.util.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyAgendaViewModel @Inject constructor(
    private val appointmentRepository: AppointmentRepository,
    private val customerRepository: CustomerRepository,
    private val sectionRepository: SectionRepository,
    private val serviceRepository: ServiceRepository
): ViewModel() {

    val appointments = appointmentRepository.getAppointments()
    val customers = customerRepository.getCustomers()
    val sections = sectionRepository.getServicesSections()
    val services = serviceRepository.getServices()

    //--> Channel to declare one time events
    private val _customerUiEvent = Channel<CustomerUiEvent>()
    val mainUiEvent = _customerUiEvent.receiveAsFlow()

    fun onCustomerUiEvent(event : CustomerListEvent){
        when(event){
            is CustomerListEvent.UpdateCustomerList -> {

            }
            is CustomerListEvent.DeleteCustomer -> {

            }
            is CustomerListEvent.UpdateCustomer -> {
                viewModelScope.launch {
                    //event.customer.copy()
                }

            }
            is CustomerListEvent.OnCustomerClick -> {

            }
            is CustomerListEvent.OnAddCustomerClick -> {
               sendCustomerUiEvent(CustomerUiEvent.Navigate(Routes.ADD_EDIT_CUSTOMER))
            }
        }
    }

    private fun sendCustomerUiEvent(event: CustomerUiEvent){
        viewModelScope.launch {
            _customerUiEvent.send(event)
        }
    }
}