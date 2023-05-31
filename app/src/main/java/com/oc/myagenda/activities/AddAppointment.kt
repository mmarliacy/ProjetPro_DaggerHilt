package com.oc.myagenda.activities

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.textfield.TextInputEditText
import com.oc.myagenda.R
import com.oc.myagenda.adapters.AppointmentAdapter
import com.oc.myagenda.adapters.CustomerDropDownMenuAdapter
import com.oc.myagenda.adapters.ServiceDropDownMenuAdapter
import com.oc.myagenda.component.CustomerBottomSheet
import com.oc.myagenda.databinding.AddAppointmentBinding
import com.oc.myagenda.fragments.AppointmentFragment
import com.oc.myagenda.fragments.CustomerFragment
import com.oc.myagenda.fragments.ServiceFragment
import com.oc.myagenda.model.Appointment
import com.oc.myagenda.model.Customer
import com.oc.myagenda.model.Service
import java.util.*

class AddAppointment : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: AddAppointmentBinding
    private lateinit var dateField: TextInputEditText
    private lateinit var timeField: TextInputEditText
    private lateinit var newAppointmentBtn : Button
    private var targetDay: Int = 0
    private var targetMonth: Int = 0
    private var targetYear: Int = 0
    private var targetHour: Int = 0
    private var targetMinutes: Int = 0

    private lateinit var finalCustomer : Customer
    private lateinit var finalDate : String
    private lateinit var finalTime : String
    private var finalServicesList : ArrayList<Service> = arrayListOf()
    private var finalPrice : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // -- Initial data --
        binding = AddAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dateField = binding.datePickerBookTxt
        timeField = binding.timePickerBookTxt
        newAppointmentBtn = binding.addNewAppointment

        // -- Methods --
        displayServicesListAndSelect()
        displayOrAddCustomerList()
        configureDateAndTime()
        addCustomer()
        cancelNewAppointment()
        createNewAppointment()
    }

    //---------------------
    // ADD NEW APPOINTMENT
    //---------------------
    private fun createNewAppointment(){
        val appointmentList = AppointmentFragment().appointmentsList
        newAppointmentBtn.setOnClickListener{
            val appointment = Appointment(finalCustomer, finalDate, finalTime, finalServicesList, finalPrice)
            appointmentList.add(appointment)
            val adapter  = AppointmentAdapter(appointmentList)
            adapter.updateList(appointmentList)
            startActivity(Intent(this, MainMenu::class.java))
            Log.i("App List", "${appointmentList.size}")
        }
    }
    //-----------
    // CUSTOMERS
    //-----------
    // 1 -- Display Customer list in AutoCompleteTextView -->
    private fun displayOrAddCustomerList() {
        // -- Get customers list and pass it to the adapter --
        val customerList = CustomerFragment().customerList
        val customerAdapter = CustomerDropDownMenuAdapter(this, customerList)
        binding.clientNameBookTxt.setAdapter(customerAdapter)
        customerAdapter.notifyDataSetChanged()
        getCustomer(customerList, customerAdapter)
    }

    // 2 -- Add new customer from appointment booking -->
    private fun addCustomer() {
        val addCustomerBtn: ImageButton = binding.addClientBookBtn
        addCustomerBtn.setOnClickListener {
            val addCustomerDialog = CustomerBottomSheet()
            addCustomerDialog.show(supportFragmentManager, CustomerBottomSheet.TAG)
        }
    }

    private fun getCustomer(customerList : ArrayList<Customer>, arrayAdapter : CustomerDropDownMenuAdapter) {
        val customersAutoComplete = findViewById<AutoCompleteTextView>(binding.clientNameBookTxt.id)
        arrayAdapter.notifyDataSetChanged()
        customersAutoComplete.setOnItemClickListener { adapter, _, position, _ ->
            val customer : Customer = adapter.getItemAtPosition(position) as Customer
            Log.i("Customer list count", customerList.size.toString())
            customersAutoComplete.setText(customer.name, false)
            finalCustomer = customer
        }
    }

    //----------
    // SERVICES
    //----------

    // 1 -- Display service list in AutoCompleteTextView -->
    private fun displayServicesListAndSelect() {
        // -- Get services list and pass it to the adapter --
        val serviceList = ServiceFragment().serviceList
        val serviceAdapter = ServiceDropDownMenuAdapter(this, serviceList)
        binding.servicesBookTxt.setAdapter(serviceAdapter)
        // -- Select service in the list and it appears in chipGroup View --
        selectServices(serviceAdapter, serviceList)
        serviceAdapter.notifyDataSetChanged()
    }

    // 2 -- Display service list in AutoCompleteTextView -->
    @SuppressLint("InflateParams")
    fun selectServices(arrayAdapter: ServiceDropDownMenuAdapter, list: ArrayList<Service>) {
        // -- Initial data --
        val chipGroup = binding.chipGroup
        var selectedService = arrayListOf<Service>()
        val servicesAutoComplete = findViewById<AutoCompleteTextView>(binding.servicesBookTxt.id)
        // -- On Item Click, service appear in chip group --
        servicesAutoComplete.setOnItemClickListener { adapter, _, position, _ ->

            val service: Service = adapter.getItemAtPosition(position) as Service
            // -- If service is composed of two strings, we make the difference --
            val tags: List<String> = if (service.name.contains(" ")) {
                service.name.split(";")
            } else {
                service.name.split(" ")
            }
            // -- For each tags, we add chip or remove it --
            for (text in tags) {
                val chip: Chip =
                    LayoutInflater.from(this).inflate(R.layout.chip_service, null, true) as Chip
                chip.text = text

                // -- We add chip, and remove it from the list --
                chipGroup.addView(chip)
                selectedService.add(service)
                list.remove(service)
                arrayAdapter.notifyDataSetChanged()

                // -- We remove chip, and add it again into the list --
                chip.setOnCloseIconClickListener {
                    chipGroup.removeView(chip)
                    selectedService.remove(service)
                    list.add(position, service) //!\ Need to settle the last index problem
                }
            }
            // -- Clean the field, to add a new service --
            servicesAutoComplete.setText(service.name, false)
        }
        selectedService = finalServicesList

        // -- Calculate total price for selected services --
        var finalPrice = 0
        for(service in selectedService) {
            val price = service.cost
            finalPrice += price
        }
    }

    //------------------
    // PICK DATE & TIME
    //------------------
    // 1 -- Configure local date and time -->
    private fun configureDateAndTime() {
        val calendar: Calendar = Calendar.getInstance()
        targetDay = calendar.get(Calendar.DAY_OF_MONTH)
        targetMonth = calendar.get(Calendar.MONTH)
        targetYear = calendar.get(Calendar.YEAR)
        targetHour = calendar.get(Calendar.HOUR)
        targetMinutes = calendar.get(Calendar.MINUTE)
        startDatePickerDialog()
        startTimePickerDialog()
    }

    // 2a -- Shows date dialog when needed -->
    private fun startDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(this, this, targetYear, targetMonth, targetDay)
        dateField.setOnClickListener {
            datePickerDialog.show()
        }
    }

    // 2b -- Shows date dialog when needed -->
    private fun startTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(this, this, targetMinutes, targetHour, true)
        timeField.setOnClickListener {
            timePickerDialog.show()
        }
    }


    // 3a -- Set date to TextInputField -->
    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        targetDay = day
        targetMonth = month
        targetMonth += 1
        targetYear = year
        val dateResult: String =
            if (day < 10 && month < 10) {
                "0${targetDay}/0${targetMonth}/${targetYear}"
            } else if (day < 10) {
                "0${targetDay}/${targetMonth}/${targetYear}"
            } else if (month < 10) {
                "${targetDay}/0${targetMonth}/${targetYear}"
            } else {
                "${targetDay}/${targetMonth}/${targetYear}"
            }
        dateField.setText(dateResult)
        finalDate = dateResult
        startTimePickerDialog()
    }

    // 3b -- Set time to TextInputField -->
    override fun onTimeSet(p0: TimePicker?, hour: Int, minutes: Int) {
        targetHour = hour
        targetMinutes = minutes
        val timeResult =
            if (hour < 10 && minutes < 10) {
                "0${targetHour}h0$targetMinutes"
            } else if (hour < 10) {
                "0${targetHour}h$targetMinutes"
            } else if (minutes < 10) {
                "${targetHour}h0$targetMinutes"
            } else {
                "${targetHour}h$targetMinutes"
            }
        timeField.setText(timeResult)
        finalTime = timeResult
    }


    //--------------------------
    // BUTTONS :: CONFIGURATION
    //--------------------------

    private fun cancelNewAppointment() {
        val cancelBtn: Button = findViewById(R.id.cancel_new_appointment)
        cancelBtn.setOnClickListener {
            startActivity(Intent(this, MainMenu::class.java))
        }
    }
}