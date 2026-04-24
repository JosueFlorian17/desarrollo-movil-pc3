package com.example.movil_pc3_josueflorian.model

import com.google.gson.annotations.SerializedName

data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val imageLinks: ImageLinks? = null
)

data class ImageLinks(
    val thumbnail: String
)

data class BooksResponse(
    val items: List<Book>? = null
)
