package com.example.mangaapp.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mangaapp.models.Data
import com.example.mangaapp.models.Manga
import com.example.mangaapp.network.MangaApi
import kotlinx.coroutines.delay

class MangaPagingSource(private val mangaApi: MangaApi) : PagingSource<Int, Data>(){
    override fun getRefreshKey(state: PagingState<Int, Data>) : Int?{
        var page : Int? = null
        if(state.anchorPosition!=null){
            val anchorPage = state.closestPageToPosition(state.anchorPosition!!)
            if(anchorPage?.prevKey!=null){
                page =  anchorPage!!.prevKey?.plus(1)
            }
            else if (anchorPage?.nextKey!=null){
                page =  anchorPage!!.nextKey?.minus(1)
            }
        }
        return page
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val position = params.key ?: 1
            var response = mangaApi.getManga(page = position)
            LoadResult.Page(
                data = response.data ,
                prevKey = if(position==1) null else position-1,
                nextKey = if (response.data.isEmpty()) null else position + 1
            )
        } catch (ex : Exception){
            LoadResult.Error(ex)
        }
    }

}