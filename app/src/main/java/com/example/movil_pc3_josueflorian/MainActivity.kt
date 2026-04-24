package com.example.movil_pc3_josueflorian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movil_pc3_josueflorian.ui.BooksApp
import com.example.movil_pc3_josueflorian.ui.BooksViewModel
import com.example.movil_pc3_josueflorian.ui.theme.Movilpc3josueflorianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
// aaa comento para poder pushear con android studio
            Movilpc3josueflorianTheme {
                val viewModel: BooksViewModel=viewModel(factory=BooksViewModel.Factory)
                Scaffold(modifier=Modifier.fillMaxSize()) {innerPadding ->
                    BooksApp(
                        booksUiState=viewModel.booksUiState,
                        modifier=Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
