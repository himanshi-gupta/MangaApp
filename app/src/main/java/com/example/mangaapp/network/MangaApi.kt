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
        @Header("x-rapidapi-key") key : String = "f6d9014397mshc2030528f69683fp1ca3acjsn8003f1261375",
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