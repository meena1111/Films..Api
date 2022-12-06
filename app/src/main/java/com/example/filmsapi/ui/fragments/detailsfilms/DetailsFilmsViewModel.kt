package com.example.filmsapi.ui.fragments.detailsfilms

import com.example.filmsapi.base.BaseViewModel
import com.example.filmsapi.data.repositories.DetailFilms
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailFilmViewModel @Inject constructor(private val repository: DetailFilms) :
    BaseViewModel() {

    fun fetchDetailFilm(id: String) = repository.fetchDetailFilms(id)
}