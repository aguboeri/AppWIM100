package com.example.appsemestral

import android.app.Application
import com.example.appsemestral.di.AppContainer
import com.example.appsemestral.nativo.NotificacionHelper

class WimApplication : Application() {

    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
        NotificacionHelper.crearCanal(this)
    }
}
