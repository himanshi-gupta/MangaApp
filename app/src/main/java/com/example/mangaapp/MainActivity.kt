package com.example.mangaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.mangaapp.database.UserDatabase
import com.example.mangaapp.network.MangaApi
import com.example.mangaapp.repository.MangaRepo
import com.example.mangaapp.screens.HomeScreen
import com.example.mangaapp.ui.theme.MangaAppTheme
import com.example.mangaapp.viewmodels.UserViewModel
import com.example.mangaapp.screens.SignIn
import com.example.mangaapp.viewmodels.MangaViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    lateinit var userViewModel: UserViewModel
    lateinit var mangaViewModel: MangaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val userDao = UserDatabase.getInstance(this).userDao()
        val mangaApi = MangaApi.getMovieApi(MangaApi.getRetrofit())
        val mangaRepo = MangaRepo(mangaApi)
        userViewModel = UserViewModel(userDao)
        mangaViewModel = MangaViewModel(mangaRepo)
        setContent {
            MangaAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(R.color.Jet_black)),
                    verticalArrangement = Arrangement.Center
                ) {
                    var email by rememberSaveable { mutableStateOf("") }
                    var paswd by rememberSaveable{ mutableStateOf("") }
                    val mangaList = mangaViewModel.mangaList.collectAsLazyPagingItems()

                    val navControl = rememberNavController()
                    NavHost(navController = navControl,
                        startDestination = "SignIn"){
                        composable("SignIn"){
                            SignIn (navControl,userViewModel, email, paswd, { email = it }, {paswd = it})
                        }
                        composable("Home Screen"){
                            HomeScreen(navControl,mangaList)
                        }
//                        composable("Detailed View/{lastscreen}/{title}/{desc}/{poster}"){
//                            val lastScreen = it.arguments?.getString("lastscreen") ?: "Landing Page"
//                            val  poster = "https://image.tmdb.org/t/p/w500/"+ (it.arguments?.getString("poster") ?: "")
//                            val  title = it.arguments?.getString("title") ?: ""
//                            val  descrptn = it.arguments?.getString("desc") ?: ""
//                            DetailedView(navController = navControl,poster,title, descrptn, lastScreen, status)
//                        }
//                        composable("Face Recognition"){
//                            Watchlist(navController = navControl, movieViewModel)
//                        }
                    }
                }
            }
        }
    }
}
