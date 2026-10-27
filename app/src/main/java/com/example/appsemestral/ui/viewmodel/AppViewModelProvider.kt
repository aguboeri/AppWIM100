package com.example.appsemestral.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.appsemestral.WimApplication

/** Fábrica de ViewModels: les entrega los repositorios del AppContainer. */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Cada pantalla agrega aquí abajo su initializer (ver docs/GUIA_PASO_A_PASO.md)
        initializer { HistorialViewModel(app().container.historialRepository) }
    }
}

private fun CreationExtras.app(): WimApplication =
    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as WimApplication
