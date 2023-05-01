package com.oc.myagenda.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationBarView
import com.oc.myagenda.R
import com.oc.myagenda.fragments.AppointmentFragment
import com.oc.myagenda.fragments.CustomerFragment
import com.oc.myagenda.fragments.ServiceFragment

class MainMenu : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    private lateinit var bottomNav: NavigationBarView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        bottomNav = findViewById(R.id.bottom_nav)
        replaceFragment(AppointmentFragment())
        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.appointments -> {
                    replaceFragment(AppointmentFragment())
                    toolbar.title = "Appointments"
                }
                R.id.clients -> {
                    replaceFragment(CustomerFragment())
                    toolbar.title = "Clients"
                }
                R.id.services -> {
                    replaceFragment(ServiceFragment())
                    toolbar.title = "Services"
                }
                else -> {

        }
        }
        true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


}