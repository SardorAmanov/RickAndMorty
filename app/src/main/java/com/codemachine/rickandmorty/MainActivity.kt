package com.codemachine.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.codemachine.rickandmorty.databinding.ActivityMainBinding
import com.codemachine.rickandmorty.presentation.adapter.CharacterAdapter
import com.codemachine.rickandmorty.presentation.ui.MainViewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        val characterAdapter = CharacterAdapter(applicationContext)

        binding.charactersRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter
        }

        this.lifecycleScope.launchWhenCreated {
            viewModel.characters.collectLatest { pagingData ->
                characterAdapter.submitData(pagingData)
            }
        }
    }
}