package com.example.mangaapp.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mangaapp.models.Data
import com.example.mangaapp.network.MangaApi
import com.example.mangaapp.paging.MangaPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking

class MangaRepo(private val mangaApi: MangaApi) {
    lateinit var listOfManga : Flow<PagingData<Data>>

    fun getMangaList(){
        listOfManga = Pager(PagingConfig(pageSize = 2)) {
            MangaPagingSource(mangaApi)
        }.flow
    }
}