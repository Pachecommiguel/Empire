package com.example.empire.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.empire.R
import com.example.empire.databinding.ActivityMainBinding
import com.example.empire.ui.LoadingLayerDelegate
import com.example.empire.ui.fragments.LoadingLayerFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LoadingLayerDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        showLoadingLayer()
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        binding.bottomNavView.setupWithNavController(navHostFragment.navController)
    }

    override fun hideLoadingLayer() {
        supportFragmentManager.findFragmentByTag(LoadingLayerFragment.TAG)?.let {
            supportFragmentManager.beginTransaction().remove(it).commit()
        }
    }

    override fun showLoadingLayer() {
        supportFragmentManager.beginTransaction().add(
            android.R.id.content,
            LoadingLayerFragment(),
            LoadingLayerFragment.TAG
        ).commit()
    }
}