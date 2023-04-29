package com.oc.myagenda.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oc.myagenda.R
import com.oc.myagenda.adapters.ClientAdapter
import com.oc.myagenda.model.Client

class ClientFragment : Fragment(R.layout.client_recycler_view)  {

    private var  clientAdapter: RecyclerView.Adapter<ClientAdapter.ViewHolder>? = null
    private lateinit var recyclerView: RecyclerView
    private var list : ArrayList<Client> = arrayListOf(
        Client("Coralie Mercier", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
        Client("Stephanie Plenozas", "0622569768", "36 Rue François, 95460 Cergy"),
        Client("Patrick Boucher", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
        Client("Marc-Antoine Laventure", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
        Client("Lorie Gua", "0697873456", "25 Av. de laQuey, 91230 Montgeron"))


    private lateinit var addBtn : Button
    private lateinit var cancelBtn : Button
    private lateinit var addClient : FloatingActionButton
    private lateinit var layout : ConstraintLayout


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.client_recycler_view)
        val manager : RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = manager
        clientAdapter = ClientAdapter(list)
        recyclerView.adapter = clientAdapter
        recyclerView.setHasFixedSize(true)

        addClient(requireContext(), view, layoutInflater)
    }


    private fun addClient(context : Context, view : View, inflater : LayoutInflater){
        //--:: 1 -- Configure dialog ::-->
        var v : View = inflater.inflate(R.layout.add_client_dialog, null)
        var dialog = Dialog(context, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen)
        dialog.setContentView(v)

        //--:: 2 -- Add button reaction ::-->
        addClient = view.findViewById(R.id.client_fab)
        addClient.setOnClickListener{
            dialog.show()

            //--:: 3 -- Click-on dialog reaction ::-->
            layout = v.findViewById(R.id.constraint)
            layout.setOnClickListener{
                dialog.dismiss()
            }
        }

    }


}
