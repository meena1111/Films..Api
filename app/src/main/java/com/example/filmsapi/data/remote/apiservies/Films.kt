package com.example.filmsapi.data.remote.apiservies

import com.example.filmsapi.data.repositories.Films
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmsApiService {

    @GET("films")
    suspend fun fetchFilms(): Response<ArrayList<Films>>

    @GET("films/{id}")
    suspend fun fetchDetailFilm(
        @Path("id")id: String
    ): Response<Films>
}