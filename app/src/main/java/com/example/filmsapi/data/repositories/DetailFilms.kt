package com.example.filmsapi.data.repositories

import com.example.filmsapi.base.BaseRepository
import com.example.filmsapi.data.remote.apiservies.FilmsApiService
import javax.inject.Inject


class DetailFilms @Inject constructor(private val service: FilmsApiService): BaseRepository() {

    fun fetchDetailFilms(id: String) = doRequest {
        service.fetchDetailFilm(id  )
    }
}