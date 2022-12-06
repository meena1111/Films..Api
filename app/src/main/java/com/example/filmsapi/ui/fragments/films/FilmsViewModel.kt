package com.example.filmsapi.ui.fragments.films

import com.example.filmsapi.base.BaseViewModel
import com.example.filmsapi.data.repositories.Films
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(private val repository: Films) :
    BaseViewModel() {

    fun fetchFilms() = repository.fetchFilms()

}