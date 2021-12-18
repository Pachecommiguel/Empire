package com.example.empire.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.empire.R
import com.example.empire.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        binding.bottomNavView.setupWithNavController(navHostFragment.navController)
    }
}