package com.upchiapas.propinas.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.upchiapas.propinas.R

@Composable
fun SelectorPropina(
    porcentaje: Int,
    onPorcentajeChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = stringResource(R.string.etiqueta_propina, porcentaje))

        // El Slider trabaja con Float, por eso convertimos de Int a Float y de regreso
        Slider(
            value = porcentaje.toFloat(),
            onValueChange = { onPorcentajeChange(it.toInt()) },
            valueRange = 0f..30f,
            steps = 29
        )
    }
}