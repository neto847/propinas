package com.upchiapas.propinas.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.upchiapas.propinas.R
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
@Composable
fun SelectorPersonas(
    numeroPersonas: Int,
    onPersonasChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.etiqueta_personas))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedButton(onClick = { onPersonasChange(numeroPersonas - 1) }) {
                Text(stringResource(R.string.boton_menos))
            }

            Text(
                text = numeroPersonas.toString(),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Button(onClick = { onPersonasChange(numeroPersonas + 1) }) {
                Text(stringResource(R.string.boton_mas))
            }
        }
    }
}