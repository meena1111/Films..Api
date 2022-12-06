package com.example.filmsapi.data.repositories

import com.example.filmsapi.base.BaseRepository
import com.example.filmsapi.data.remote.apiservies.FilmsApiService
import javax.inject.Inject

class Films @Inject constructor(private val service: FilmsApiService) : BaseRepository() {

    fun fetchFilms() = doRequest {
        service.fetchFilms()
    }
}