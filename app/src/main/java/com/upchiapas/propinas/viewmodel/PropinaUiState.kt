package com.upchiapas.propinas.viewmodel

// Los 3 niveles de propina (sirven para cambiar el color de la tarjeta)
enum class NivelPropina {
    BAJA, NORMAL, GENEROSA
}

// Aquí vive TODO lo que la pantalla necesita mostrar
data class PropinaUiState(
    // Datos que el usuario escribe o elige
    val monto: String = "",
    val porcentajePropina: Int = 15,
    val numeroPersonas: Int = 1,
    val redondear: Boolean = false,

    // Resultados (ya vienen formateados desde el ViewModel)
    val propina: String = "0.00",
    val total: String = "0.00",
    val porPersona: String = "0.00",
    val nivelPropina: NivelPropina = NivelPropina.NORMAL
)