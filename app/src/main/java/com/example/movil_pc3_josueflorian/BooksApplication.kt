package com.example.movil_pc3_josueflorian

import android.app.Application
import com.example.movil_pc3_josueflorian.data.AppContainer
import com.example.movil_pc3_josueflorian.data.DefaultAppContainer

class BooksApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=DefaultAppContainer()
    }
}
