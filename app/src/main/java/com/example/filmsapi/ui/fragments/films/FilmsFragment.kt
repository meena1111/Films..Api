package com.example.filmsapi.ui.fragments.films

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.filmsapi.R
import com.example.filmsapi.base.BaseFragment
import com.example.filmsapi.databinding.FragmentFilmsBinding
import com.example.filmsapi.models.FilmsModel
import com.example.filmsapi.ui.adapters.FilmsAdapter
import com.example.filmsapi.ui.fragments.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : BaseFragment<FragmentFilmsBinding, FilmsViewModel>(R.layout.fragment_films),
    OnItemClickListener {

    override val binding by viewBinding(FragmentFilmsBinding::bind)
    override val viewModel: FilmsViewModel by viewModels()
    private val filmsAdapter = FilmsAdapter(this)

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        viewModel.fetchFilms().subscribe(
            onSuccess = {
                filmsAdapter.submitList(it)
            },
            onError = {
                Log.e("film", it)
            }
        )
    }

    private fun setupRecyclerView() {
        binding.filmsRecyclerView.adapter = filmsAdapter
    }

    override fun onItemClick(model: FilmsModel) {
        findNavController().navigate(
            FilmsFragmentDirections.actionFilmsFragmentToDetailFilmsFragment().setId(model.id)
        )
    }
}
