package com.example.noteapp.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.utils.SharedPreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        navController = navHostFragment.navController

        sharedPreferenceHelper = SharedPreferenceHelper(this@MainActivity)

        if (!sharedPreferenceHelper.isOnBoardingComplete()) {
            sharedPreferenceHelper.setOnBoardingComplete(true)
        } else {
            navController.navigate(R.id.noteFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(@NonNull item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_home -> {
                navController.navigate(R.id.noteFragment)
                Toast.makeText(this, "Note selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_message -> {
                navController.navigate(R.id.chatFragment)
                Toast.makeText(this, "Chat selected", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
