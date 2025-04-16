package com.example.mangaapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaapp.database.User
import com.example.mangaapp.database.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.contracts.Returns

class UserViewModel(val userDao: UserDao) : ViewModel(){
    suspend fun getPaswd(email : String) : String{
        val paswd = viewModelScope.async{
            userDao.getPaswd(email)
        }
        return paswd.await()
    }

    fun addUser(email: String, paswd : String){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.insert(User(email,paswd))
        }
    }

    suspend fun login(email: String, paswd: String){
        viewModelScope.launch {
            val savedPaswd = getPaswd(email)
            if(savedPaswd=="")
                addUser(email,paswd)
        }
    }
}