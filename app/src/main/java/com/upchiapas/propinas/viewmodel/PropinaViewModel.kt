package com.upchiapas.propinas.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale
import kotlin.math.ceil

class PropinaViewModel : ViewModel() {

    // Versión privada: solo el ViewModel puede modificarla
    private val _uiState = MutableStateFlow(PropinaUiState())

    // Versión pública: la pantalla solo puede leerla
    val uiState: StateFlow<PropinaUiState> = _uiState.asStateFlow()

    // EVENTOS: la pantalla los llama cuando el usuario hace algo

    fun onMontoChange(nuevoMonto: String) {
        // Regla de negocio: solo aceptamos vacío o un número válido
        if (nuevoMonto.isEmpty() || nuevoMonto.toDoubleOrNull() != null) {
            _uiState.value = _uiState.value.copy(monto = nuevoMonto)
            calcular()
        }
    }

    fun onPropinaChange(nuevoPorcentaje: Int) {
        _uiState.value = _uiState.value.copy(porcentajePropina = nuevoPorcentaje)
        calcular()
    }

    fun onPersonasChange(nuevasPersonas: Int) {
        // Regla de negocio: mínimo 1 persona
        _uiState.value = _uiState.value.copy(
            numeroPersonas = nuevasPersonas.coerceAtLeast(1)
        )
        calcular()
    }

    fun onRedondearChange(redondear: Boolean) {
        _uiState.value = _uiState.value.copy(redondear = redondear)
        calcular()
    }

    // LÓGICA: aquí se hacen todos los cálculos
    private fun calcular() {
        val estado = _uiState.value

        // Si el texto no es un número (por ejemplo está vacío) usamos 0
        val monto = estado.monto.toDoubleOrNull() ?: 0.0

        var propina = monto * estado.porcentajePropina / 100
        var total = monto + propina

        // Si el switch está activado, el total sube al siguiente entero
        if (estado.redondear) {
            total = ceil(total)
            propina = total - monto
        }

        val porPersona = total / estado.numeroPersonas

        // El nivel decide el color de la tarjeta
        val nivel = when {
            estado.porcentajePropina < 10 -> NivelPropina.BAJA
            estado.porcentajePropina <= 18 -> NivelPropina.NORMAL
            else -> NivelPropina.GENEROSA
        }

        // Copiamos el estado con los resultados nuevos
        _uiState.value = estado.copy(
            propina = formatear(propina),
            total = formatear(total),
            porPersona = formatear(porPersona),
            nivelPropina = nivel
        )
    }

    // Convierte un número a texto con 2 decimales, por ejemplo 12.5 -> "12.50"
    private fun formatear(valor: Double): String {
        return String.format(Locale.US, "%.2f", valor)
    }
}