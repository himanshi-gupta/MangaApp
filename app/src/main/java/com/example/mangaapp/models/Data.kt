package com.example.mangaapp.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id"            ) var id           : String?           = null,
    @SerializedName("title"         ) var title        : String?           = null,
    @SerializedName("sub_title"     ) var subTitle     : String?           = null,
    @SerializedName("status"        ) var status       : String?           = null,
    @SerializedName("thumb"         ) var thumb        : String?           = null,
    @SerializedName("summary"       ) var summary      : String?           = null,
    @SerializedName("authors"       ) var authors      : ArrayList<String> = arrayListOf(),
    @SerializedName("genres"        ) var genres       : ArrayList<String> = arrayListOf(),
    @SerializedName("nsfw"          ) var nsfw         : Boolean?          = null,
    @SerializedName("type"          ) var type         : String?           = null,
    @SerializedName("total_chapter" ) var totalChapter : Int?              = null,
    @SerializedName("create_at"     ) var createAt     : Long?              = null,
    @SerializedName("update_at"     ) var updateAt     : Long?              = null

)
