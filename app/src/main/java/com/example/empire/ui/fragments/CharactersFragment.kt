package com.example.empire.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.empire.R
import com.example.empire.databinding.FragmentCharactersBinding
import com.example.empire.ui.recycler.CharacterListAdapter
import com.example.empire.ui.viewmodels.CharactersFragmentViewModel

class CharactersFragment : Fragment() {

    private val viewModel: CharactersFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val listAdapter = CharacterListAdapter()

        FragmentCharactersBinding.inflate(layoutInflater).addressRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        viewModel.characterList.observe(viewLifecycleOwner, listAdapter::submitList)

        return inflater.inflate(R.layout.fragment_characters, container, false)
    }
}