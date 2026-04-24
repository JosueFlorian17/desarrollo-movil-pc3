package com.example.movil_pc3_josueflorian.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.movil_pc3_josueflorian.BooksApplication
import com.example.movil_pc3_josueflorian.data.BooksRepository
import com.example.movil_pc3_josueflorian.model.Book
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BooksUiState {
    data class Success(val books: List<Book>) : BooksUiState
    object Error : BooksUiState
    object Loading : BooksUiState
}

class BooksViewModel(private val booksRepository: BooksRepository) : ViewModel() {
    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        getBooks()
    }

    fun getBooks(query: String = "jazz history") {
        viewModelScope.launch {
            booksUiState=BooksUiState.Loading
            booksUiState=try {
                BooksUiState.Success(booksRepository.getBooks(query))
            } catch (e: IOException) {
                BooksUiState.Error
            } catch (e: Exception) {
                BooksUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application=(this[APPLICATION_KEY] as BooksApplication)
                val booksRepository=application.container.booksRepository
                BooksViewModel(booksRepository=booksRepository)
            }
        }
    }
}
