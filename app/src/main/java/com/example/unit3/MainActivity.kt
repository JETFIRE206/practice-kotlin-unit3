package com.example.unit3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.unit3.databinding.ActivityMainBinding
import com.example.unit3.view.PracticeHighOrderFunc
import com.example.unit3.view.PracticeLambdasFragment

// Generally, your fragment must be embedded within an AndroidX "FragmentActivity" to contribute a
// portion of UI to that activity's layout. "FragmentActivity" is the base class for
// "AppCompatActivity", so if you're already subclassing "AppCompatActivity" to provide backward
// compatibility in your app, then you do not need to change your activity base class.
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(binding.fragmentContainerView.id, fragment)
        }
    }
}