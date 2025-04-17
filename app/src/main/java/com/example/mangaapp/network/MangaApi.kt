package com.example.mangaapp.network

import com.example.mangaapp.models.Manga
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MangaApi {
    @GET("manga/fetch")
    suspend fun getManga(
        @Header("x-rapidapi-host") host: String = "mangaverse-api.p.rapidapi.com",
        @Header("x-rapidapi-key") key : String = "eaff41ad2fmshdd2c52af7e23af3p12b53fjsn2a1e0d86ef7c",
        @Query("page") page : Int
    ) : Manga

    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://mangaverse-api.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

        fun getMovieApi(retrofit: Retrofit): MangaApi {
            return retrofit.create(MangaApi::class.java)
        }
    }
}