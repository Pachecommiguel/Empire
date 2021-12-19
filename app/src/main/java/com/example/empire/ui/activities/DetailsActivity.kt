package com.example.empire.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.empire.databinding.ActivityDetailsBinding
import com.example.empire.ui.fragments.CharactersFragment
import com.example.empire.ui.viewmodels.DetailsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val viewModel: DetailsFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.onCharacterName(intent.extras?.getString(CharactersFragment.CHARACTER_NAME))
        binding.character = viewModel.character
    }
}