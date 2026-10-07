package com.upchiapas.propinas.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.upchiapas.propinas.R

// Recibe el monto (state down) y avisa cuando cambia (event up)
@Composable
fun CampoMonto(
    monto: String,
    onMontoChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = monto,
        onValueChange = onMontoChange,
        label = { Text(stringResource(R.string.etiqueta_monto)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        singleLine = true,
        modifier = modifier.fillMaxWidth()
    )
}