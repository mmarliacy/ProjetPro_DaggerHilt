package com.oc.myagenda.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oc.myagenda.utils.Data
import com.oc.myagenda.R
import com.oc.myagenda.ui.adapters.CustomerAdapter
import com.oc.myagenda.ui.component.CustomerBottomSheet
import com.oc.myagenda.database.entities.Customer
import com.oc.myagenda.databinding.CustomerFragmentBinding
import com.oc.myagenda.ui.component.AddCustomerListener
import com.oc.myagenda.viewmodels.MainViewModel
import java.util.*

class CustomerFragment : Fragment(R.layout.customer_fragment)  {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addClient : FloatingActionButton
    var filteredCustomerList = arrayListOf<Customer>()
    var fCustomerAdapter = CustomerAdapter()
    var customerList = Data.customerList

    private val viewModel : MainViewModel by viewModels()
    private var _binding : CustomerFragmentBinding? = null
        private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CustomerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.client_recycler_view)
        setUpRecyclerView()
        addClient(view)
        setCustomerFilter()
    }

    private fun setCustomerFilter(){
        val mainActivity = requireActivity()
        mainActivity.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                val item = menu.findItem(R.id.search)
                val searchView = item.actionView as SearchView

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(p0: String?): Boolean {
                        return false
                    }
                    @SuppressLint("NotifyDataSetChanged")
                    override fun onQueryTextChange(text : String?): Boolean {
                        filteredCustomerList.clear()
                        val searchText = text!!.lowercase(Locale.getDefault())
                        if (searchText.isNotEmpty()) {
                            customerList.forEach {
                                if (it.name.lowercase(Locale.getDefault()).contains(searchText)) {
                                    filteredCustomerList.add(it)
                                }
                            }
                            recyclerView.adapter!!.notifyDataSetChanged()

                        } else {
                            filteredCustomerList.clear()
                            filteredCustomerList.addAll(customerList)
                            recyclerView.adapter!!.notifyDataSetChanged()
                        }
                        return false
                    }
                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.search -> {
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setUpRecyclerView(){
        val manager : RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = manager
        fCustomerAdapter = CustomerAdapter()
        filteredCustomerList.addAll(customerList)
        fCustomerAdapter.pCustomerList = filteredCustomerList
        recyclerView.adapter = fCustomerAdapter
        recyclerView.setHasFixedSize(true)
    }


    private fun addClient(view : View){
        //--:: 1 -- Configure dialog ::-->
        val dialog = CustomerBottomSheet(object : AddCustomerListener{
            override fun addCustomer(customer: Customer) {
                viewModel.insertCustomer(customer)
            }

        })
        //--:: 2 -- Add button reaction ::-->
        addClient = view.findViewById(R.id.client_fab)
        addClient.setOnClickListener{
            dialog.show(parentFragmentManager, CustomerBottomSheet.TAG)
        }
    }
}
