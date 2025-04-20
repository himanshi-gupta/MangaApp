package com.example.mangaapp.viewmodels

import androidx.annotation.BoolRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaapp.database.User
import com.example.mangaapp.database.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.contracts.Returns

class UserViewModel(val userDao: UserDao) : ViewModel(){
    suspend fun getPaswd(email : String) : String{
        return withContext(Dispatchers.IO) {
            userDao.getPaswd(email)
        }
    }

    fun addUser(email: String, paswd : String){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.insert(User(email,paswd))
        }
    }

    suspend fun userAuthenticator(email: String, paswd: String) : Boolean{
        return withContext(Dispatchers.IO){
            val savedPaswd = getPaswd(email)
            if (savedPaswd == "" || savedPaswd == null) {
                addUser(email, paswd)
                true
            } else {
                savedPaswd == paswd
            }
        }
    }
}