package com.oc.myagenda.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oc.myagenda.Data
import com.oc.myagenda.R
import com.oc.myagenda.adapters.service.SectionAdapter
import com.oc.myagenda.component.ServiceBottomSheet
import com.oc.myagenda.model.Service
import com.oc.myagenda.model.ServiceSection

class ServiceFragment : Fragment(R.layout.service_recycler_view) {
    private lateinit var sectionAdapter : SectionAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNewService: FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView(view)
        connectAddServiceBtn(view)
    }

    private fun configureRecyclerView(view : View){
        val manager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.section_recycler_view)
        sectionAdapter = SectionAdapter(Data.sectionServiceList)
        recyclerView.apply {
            layoutManager = manager
            adapter = sectionAdapter
        }
        setServiceFilter()
    }

    //-- Set search view by letter based on Filter declared in recyclerview adapter  --
    private fun setServiceFilter(){
        val mainActivity = requireActivity()
        mainActivity.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                val item = menu.findItem(R.id.search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(s: String): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(s: String): Boolean {
                        sectionAdapter.getFilter().filter(s)
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

    private fun connectAddServiceBtn(view: View) {
        addNewService = view.findViewById(R.id.service_fab)

        addNewService.setOnClickListener {
            val serviceDialog = ServiceBottomSheet()
            serviceDialog.show(parentFragmentManager, ServiceBottomSheet.TAG)
        }
    }
}