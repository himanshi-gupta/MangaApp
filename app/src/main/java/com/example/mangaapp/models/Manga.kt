package com.example.mangaapp.models
import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("code" ) var code : Int?            = null,
    @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()
)
