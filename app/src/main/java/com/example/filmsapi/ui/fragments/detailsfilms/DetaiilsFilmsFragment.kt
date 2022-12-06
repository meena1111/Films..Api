package com.example.filmsapi.ui.fragments.detailsfilms

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.filmsapi.R
import com.example.filmsapi.base.BaseFragment
import com.example.filmsapi.data.repositories.Films
import com.example.filmsapi.databinding.FragmentDetailsFilmsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFilmsFragment :
    BaseFragment<FragmentDetailsFilmsBinding, DetailFilmViewModel>(R.layout.fragment_details_films) {
    override val binding by viewBinding(FragmentDetailsFilmsBinding::bind)
    override val viewModel: DetailFilmViewModel by viewModels()
    private val saveArgs: DetailFilmsFragmentArgs by navArgs<DetailFilmsFragmentArgs>()

    override fun initialize() {
    }

    override fun setupSubscribe() {
        viewModel.fetchDetailFilm(saveArgs.id).subscribe(
            onSuccess = {
                addDateInView(it)
            },
            onError = {
                Log.e("film", it)
            }
        )
    }

    private fun addDateInView(model: Films) {
        binding.imageFilmsDetail.load(model.image)
        binding.txtDetail.text = model.title
        binding.txtDescriptionDetail.text = model.description
        binding.txtProducerDetail.text = model.produser

    }
}
