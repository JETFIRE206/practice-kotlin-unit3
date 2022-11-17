package com.example.unit3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.unit3.databinding.ActivityMainBinding
import com.example.unit3.view.PracticeHighOrderFunc
import com.example.unit3.view.PracticeLambdasFragment
import com.google.android.material.navigation.NavigationView

// Generally, your fragment must be embedded within an AndroidX "FragmentActivity" to contribute a
// portion of UI to that activity's layout. "FragmentActivity" is the base class for
// "AppCompatActivity", so if you're already subclassing "AppCompatActivity" to provide backward
// compatibility in your app, then you do not need to change your activity base class.
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLambdas.setOnClickListener {
            replaceFragment(PracticeLambdasFragment())
        }

        binding.buttonHigherOrderFunc.setOnClickListener {
            replaceFragment(PracticeHighOrderFunc())
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when (it.itemId) {
                R.id.nav_lambda -> replaceFragment(PracticeLambdasFragment())
                R.id.nav_high_order_func -> replaceFragment(PracticeHighOrderFunc())
                else -> replaceFragment(PracticeLambdasFragment())
            }

            drawerLayout.closeDrawers()

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(binding.fragmentContainerView.id, fragment)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}