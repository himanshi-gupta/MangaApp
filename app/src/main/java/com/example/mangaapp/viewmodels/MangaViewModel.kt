package com.example.mangaapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.mangaapp.models.Data
import com.example.mangaapp.models.Manga
import com.example.mangaapp.network.MangaApi
import com.example.mangaapp.repository.MangaRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MangaViewModel(private val mangaRepo: MangaRepo) : ViewModel(){


    val mangaList : Flow<PagingData<Data>>
        get() = mangaRepo.listOfManga

    init {
        getListOfManga()
    }


    fun getListOfManga(){
        viewModelScope.launch(Dispatchers.IO) {
            mangaRepo.getMangaList()
        }
    }

//    suspend fun getMangalist(){
//        var manga : Manga? = null
//        val r = viewModelScope.async(Dispatchers.IO) {
//            manga = MangaApi.getMovieApi(MangaApi.getRetrofit()).getManga(page = 1)
//        }
//        r.await()
//        Log.d("Himanshi","${manga?.data}")
//    }
}