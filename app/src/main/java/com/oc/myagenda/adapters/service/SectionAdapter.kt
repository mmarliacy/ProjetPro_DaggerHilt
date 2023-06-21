package com.oc.myagenda.adapters.service

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

class SectionAdapter(var sectionList: ArrayList<ServiceSection>) :
    RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    lateinit var servicesList: ArrayList<Service>
    var fullSectionList: ArrayList<ServiceSection> = ArrayList(sectionList)
    lateinit var service: Service


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.section_item, parent, false)
        return SectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val section = sectionList[position]
        holder.sectionField.text = section.section
        servicesList = section.serviceList
        val manager = LinearLayoutManager(holder.itemView.context)
        val serviceAdapter = ServiceAdapter(servicesList)
        holder.serviceRecyclerView.layoutManager = manager
        holder.serviceRecyclerView.adapter = serviceAdapter

    }

    private val filter: Filter = object : Filter() {
        //-- Performing filter based on names of Room in RV by focusing on chars of each elements --
        @SuppressLint("NotifyDataSetChanged")
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filteredSectionList: ArrayList<ServiceSection> = ArrayList()
            val fullServiceList: ArrayList<Service> = ArrayList()
            val filteredServiceList: ArrayList<Service> = ArrayList()
            for (index in 0 until fullSectionList.size) {
                if (fullSectionList[index].serviceList.isNotEmpty()) {
                    fullServiceList.addAll(fullSectionList[index].serviceList)
                }
            }
            if (charSequence.isEmpty()) {
                filteredSectionList.addAll(fullSectionList)
            } else {
                val filterPattern =
                    charSequence.toString().lowercase(Locale.getDefault()).trim { it <= ' ' }

                //--> Filter services
                fullServiceList.forEach {
                    if (it.name.lowercase(Locale.getDefault()).contains(filterPattern)) {
                        filteredServiceList.add(it)
                    }
                }
                //--> Filter section with the selected services
                for (index in 0 until filteredServiceList.size) {
                sectionList.forEach{
                        if (it.serviceList.contains(filteredServiceList[index])) {
                            filteredSectionList.add(it)
                            it.serviceList.clear()
                            it.serviceList.add(filteredServiceList[index])
                        }
                }
            }
            }
            val filterResults = FilterResults()
            filterResults.values = filteredSectionList
            return filterResults
        }

        //-- Clean, publish elements in recyclerview and notify to the adapter --
        @SuppressLint("NotifyDataSetChanged")
        @Suppress("UNCHECKED_CAST")
        override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
            sectionList.clear()
            sectionList.addAll(filterResults.values as Collection<ServiceSection>)
            notifyDataSetChanged()
        }
    }

    //-- CREATE FILTER METHOD BASED ON RECYCLERVIEW -->
    fun getFilter(): Filter {
        return filter
    }

    override fun getItemCount(): Int {
        return sectionList.size
    }

    class SectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var sectionField: TextView = view.findViewById(R.id.section_name)
        var serviceRecyclerView: RecyclerView = view.findViewById(R.id.services_recyclerview)

    }

}