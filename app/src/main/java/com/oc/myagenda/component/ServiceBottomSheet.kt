package com.oc.myagenda.component

import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.oc.myagenda.R

class ServiceBottomSheet : BottomSheetDialogFragment(R.layout.add_service_dialog){

    private lateinit var addServiceBtn : Button

    companion object {
        const val TAG = "ServiceBottomSheet"
    }
}