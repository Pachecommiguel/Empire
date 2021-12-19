package com.example.empire.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.empire.databinding.FragmentCharactersBinding
import com.example.empire.persistence.entities.Character
import com.example.empire.ui.LoadingLayerDelegate
import com.example.empire.ui.recycler.CharacterListAdapter
import com.example.empire.ui.recycler.FavoriteListener
import com.example.empire.ui.viewmodels.CharactersFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment(), FavoriteListener {

    private val viewModel: CharactersFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listAdapter = CharacterListAdapter(this)
        val binding = FragmentCharactersBinding.inflate(inflater, container, false)

        binding.characterRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        viewModel.characterList.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                listAdapter.submitList(it)
                (activity as LoadingLayerDelegate).hideLoadingLayer()
            }
        })

        return binding.root
    }

    override fun onFavoriteClick(checked: Boolean, character: Character) {
        viewModel.onFavoriteClick(checked, character)
    }
}
