package com.upchiapas.propinas.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.upchiapas.propinas.R
import com.upchiapas.propinas.components.CampoMonto
import com.upchiapas.propinas.components.SelectorPersonas
import com.upchiapas.propinas.components.SelectorPropina
import com.upchiapas.propinas.components.SwitchRedondear
import com.upchiapas.propinas.components.TarjetaResultado
import com.upchiapas.propinas.viewmodel.PropinaViewModel

@Composable
fun PropinaScreen(
    modifier: Modifier = Modifier,
    viewModel: PropinaViewModel = viewModel()
) {
    // Aquí la pantalla "escucha" el estado del ViewModel.
    // Cada vez que cambia, Compose vuelve a dibujar (recomposición).
    val estado by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.titulo),
            style = MaterialTheme.typography.headlineMedium
        )

        // State down: le pasamos el estado a cada componente
        // Events up: le pasamos la función del ViewModel que debe llamar
        CampoMonto(
            monto = estado.monto,
            onMontoChange = viewModel::onMontoChange
        )

        SelectorPropina(
            porcentaje = estado.porcentajePropina,
            onPorcentajeChange = viewModel::onPropinaChange
        )

        SelectorPersonas(
            numeroPersonas = estado.numeroPersonas,
            onPersonasChange = viewModel::onPersonasChange
        )

        SwitchRedondear(
            redondear = estado.redondear,
            onRedondearChange = viewModel::onRedondearChange
        )

        TarjetaResultado(
            propina = estado.propina,
            total = estado.total,
            porPersona = estado.porPersona,
            nivel = estado.nivelPropina
        )
    }
}