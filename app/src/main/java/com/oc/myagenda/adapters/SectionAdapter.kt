package com.oc.myagenda.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oc.myagenda.R
import com.oc.myagenda.model.Service
import com.oc.myagenda.model.ServiceSection
import java.util.*
import kotlin.collections.ArrayList

class SectionAdapter : RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    var sectionList: ArrayList<ServiceSection> = ArrayList()
    lateinit var servicesList: ArrayList<Service>
    var filteredServiceList: ArrayList<Service> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.section_item, parent, false)
        return SectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val section = sectionList[position]
        holder.sectionField.text = section.section
        servicesList = section.serviceList
        val manager = LinearLayoutManager(holder.itemView.context)
        holder.serviceRecyclerView.layoutManager = manager
        val serviceAdapter = ServiceAdapter(servicesList)
        holder.serviceRecyclerView.adapter = serviceAdapter
    }

    override fun getItemCount(): Int {
        return sectionList.size
    }


    class SectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var sectionField: TextView = view.findViewById(R.id.section_name)
        var serviceRecyclerView : RecyclerView = view.findViewById(R.id.services_recyclerview)

    }

    //-- CREATE FILTER METHOD BASED ON RECYCLERVIEW -->
    fun getFilter(): Filter {
        return filter
    }

    private val filter: Filter = object : Filter() {
        //-- Performing filter based on names of Room in RV by focusing on chars of each elements --
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val serviceList: MutableList<Service> = servicesList
            if (charSequence.isEmpty()) {
                filteredServiceList.addAll(serviceList)
            } else {
                val filterPattern =
                    charSequence.toString().lowercase(Locale.getDefault()).trim { it <= ' ' }
                serviceList.forEach {
//
                    if (it.name.lowercase(Locale.getDefault()).contains(filterPattern)) {
                        filteredServiceList.add(it)
                    }

                }
            }
            val filterResults = FilterResults()
            filterResults.values = filteredServiceList
            return filterResults
        }

        //-- Clean, publish elements in recyclerview and notify to the adapter --
        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
            servicesList.clear()
            servicesList.addAll(filterResults.values as Collection<Service>)
            notifyDataSetChanged()
        }
    }

}