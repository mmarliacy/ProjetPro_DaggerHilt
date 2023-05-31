package com.oc.myagenda.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationBarView
import com.oc.myagenda.R
import com.oc.myagenda.databinding.ActivityMainMenuBinding
import com.oc.myagenda.fragments.AppointmentFragment
import com.oc.myagenda.fragments.CustomerFragment
import com.oc.myagenda.fragments.ServiceFragment

class MainMenu : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    private lateinit var bottomNav: NavigationBarView
    private lateinit var mainBinding : ActivityMainMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        toolbar = mainBinding.toolbar
        bottomNav = mainBinding.bottomNav

        setSupportActionBar(toolbar)
        replaceFragment(AppointmentFragment())
        setBottomNav()

        // Add menu items without overriding methods in the Activity
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return true
            }
        } )

    }

    private fun setBottomNav(){
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
}