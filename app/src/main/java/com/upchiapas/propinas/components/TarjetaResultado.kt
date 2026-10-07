package com.upchiapas.propinas.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.upchiapas.propinas.R
import com.upchiapas.propinas.viewmodel.NivelPropina

@Composable
fun TarjetaResultado(
    propina: String,
    total: String,
    porPersona: String,
    nivel: NivelPropina,
    modifier: Modifier = Modifier
) {
    // El color de la tarjeta cambia según el nivel de propina
    val colorFondo = when (nivel) {
        NivelPropina.BAJA -> Color(0xFFFFCDD2)
        NivelPropina.NORMAL -> Color(0xFFFFF9C4)
        NivelPropina.GENEROSA -> Color(0xFFC8E6C9)
    }

    // El texto que acompaña a cada nivel
    val textoNivel = when (nivel) {
        NivelPropina.BAJA -> stringResource(R.string.nivel_baja)
        NivelPropina.NORMAL -> stringResource(R.string.nivel_normal)
        NivelPropina.GENEROSA -> stringResource(R.string.nivel_generosa)
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorFondo,
            contentColor = Color.Black
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = textoNivel)
            Text(text = stringResource(R.string.resultado_propina) + ": " + stringResource(R.string.moneda, propina))
            Text(text = stringResource(R.string.resultado_total) + ": " + stringResource(R.string.moneda, total))
            Text(text = stringResource(R.string.resultado_por_persona) + ": " + stringResource(R.string.moneda, porPersona))
        }
    }
}