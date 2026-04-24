package com.example.movil_pc3_josueflorian.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movil_pc3_josueflorian.model.Book

@Composable
fun BooksApp(
    booksUiState: BooksUiState,
    modifier: Modifier=Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color= MaterialTheme.colorScheme.background
    ) {when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen()
        is BooksUiState.Success -> BooksGridScreen(booksUiState.books)
        is BooksUiState.Error -> ErrorScreen()
    }}

}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = "Cargando imagens...", modifier = modifier.fillMaxWidth())
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text(text = "Error al cargar \n las imagenes", modifier=modifier.fillMaxWidth())
}

@Composable
fun BooksGridScreen(books: List<Book>, modifier: Modifier=Modifier) {
    Text(text="Books", modifier=modifier.fillMaxWidth())
    LazyVerticalGrid(
        columns=GridCells.Adaptive(150.dp),modifier=modifier.fillMaxWidth(),contentPadding=PaddingValues(4.dp)
    ) {
        items(items = books, key={ book -> book.id }) { book ->
            BookCard(
                book = book,
                modifier = modifier.padding(4.dp).fillMaxWidth().aspectRatio(1.5f)
            )
        }
    }
}

@Composable
fun BookCard(book: Book, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data(book.volumeInfo.imageLinks?.thumbnail?.replace("http", "https")).crossfade(true).build(),
                contentDescription = book.volumeInfo.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text=book.volumeInfo.title,
                modifier=Modifier.padding(8.dp),
                style=MaterialTheme.typography.titleSmall
                // dejo este comentario aqui porque ya no funcionaaaaaa
            )
        }
    }
}
