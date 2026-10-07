package com.upchiapas.propinas.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PropinaViewModel : ViewModel() {

    // Versión privada: solo el ViewModel puede modificarla
    private val _uiState = MutableStateFlow(PropinaUiState())

    // Versión pública: la pantalla solo puede leerla
    val uiState: StateFlow<PropinaUiState> = _uiState.asStateFlow()

    // EVENTOS: la pantalla los llama cuando el usuario hace algo
    fun onMontoChange(nuevoMonto: String) {
        _uiState.value = _uiState.value.copy(monto = nuevoMonto)
    }

    fun onPropinaChange(nuevoPorcentaje: Int) {
        _uiState.value = _uiState.value.copy(porcentajePropina = nuevoPorcentaje)
    }

    fun onPersonasChange(nuevasPersonas: Int) {
        // Regla de negocio: mínimo 1 persona
        _uiState.value = _uiState.value.copy(
            numeroPersonas = nuevasPersonas.coerceAtLeast(1)
        )
    }

    fun onRedondearChange(redondear: Boolean) {
        _uiState.value = _uiState.value.copy(redondear = redondear)
    }
}