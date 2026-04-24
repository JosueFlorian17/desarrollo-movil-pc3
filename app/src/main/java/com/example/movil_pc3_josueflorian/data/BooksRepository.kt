package com.example.movil_pc3_josueflorian.data

import com.example.movil_pc3_josueflorian.model.Book
import com.example.movil_pc3_josueflorian.network.BooksApiService

interface BooksRepository {
    suspend fun getBooks(query: String): List<Book>
}

class NetworkBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {
    override suspend fun getBooks(query: String): List<Book> {
        return booksApiService.getBooks(query).items ?: emptyList()
    }
}
