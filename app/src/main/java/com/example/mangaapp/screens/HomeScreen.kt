package com.example.mangaapp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.mangaapp.R
import com.example.mangaapp.models.Data
import com.example.mangaapp.viewmodels.MangaViewModel
import java.net.URLEncoder

@Composable
fun HomeScreen(navController: NavController, mangaList : LazyPagingItems<Data>){
    Log.d("Himanshi","$mangaList.itemCount")

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(mangaList.itemCount) { index ->
            val manga = mangaList[index]
            manga?.let {
                AsyncImage(
                    model = "${it.thumb}",
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
//                        .padding(5.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .clickable {
                            val encodedTitle = URLEncoder.encode(it.title, "UTF-8")
                            val encodedSubtitle = URLEncoder.encode(it.subTitle, "UTF-8")
                            val encodedSummary = URLEncoder.encode(it.summary, "UTF-8")
                            val encodedUrl = URLEncoder.encode(it.thumb, "UTF-8")
                            navController.navigate("Detailed View/$encodedTitle/$encodedSubtitle/$encodedSummary/$encodedUrl") },
                    error = painterResource(id = R.drawable.ic_launcher_background)
                )

            }
        }
    }
}