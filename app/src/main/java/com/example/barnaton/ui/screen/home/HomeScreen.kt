package com.example.barnaton.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.barnaton.data.Resource
import com.example.barnaton.domain.model.TvSeries
import com.example.barnaton.ui.components.Banner
import com.example.barnaton.ui.components.HomeSection
import com.example.barnaton.ui.components.TvSeriesList
import com.example.barnaton.ui.theme.midNightBlue

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getAllOnAir()
        viewModel.getAllPopular()
        viewModel.getAllTopRated()
    }
    val stateOnAir by viewModel.uiStateOnAir.collectAsState()
    val statePopular by viewModel.uiStatePopular.collectAsState()
    val stateTopRated by viewModel.uiStateTopRated.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(midNightBlue)
    ) {
        LazyColumn(
        ) {

            item {
                Banner()
            }

            item {
                TVSeriesOnAir(stateOnAir = stateOnAir)
            }
            item {
                TvSeriesPopular(statePopular = statePopular)
            }
            item {
                TVSeriesTopRated(stateTopRated = stateTopRated)
            }
        }
    }
}


@Composable
private fun TVSeriesOnAir(
    stateOnAir: Resource<List<TvSeries>>,
    modifier: Modifier = Modifier
) {
    HomeSection(title = "TV Series On Air") {
        when (stateOnAir) {
            is Resource.Error -> {
                Text(text = stateOnAir.message ?: "Error tidak diketahui")
            }

            is Resource.Loading -> {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is Resource.Success -> {
                TvSeriesList(
                    items = stateOnAir.data ?: emptyList(),
                    modifier = modifier
                )
            }
        }
    }
}

@Composable
private fun TVSeriesTopRated(
    stateTopRated: Resource<List<TvSeries>>,
    modifier: Modifier = Modifier
) {
    HomeSection(title = "TV Series Top Rated") {
        when (stateTopRated) {
            is Resource.Error -> {
                Text(text = stateTopRated.message ?: "Error tidak diketahui")
            }

            is Resource.Loading -> {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is Resource.Success -> {
                TvSeriesList(
                    items = stateTopRated.data ?: emptyList(),
                    modifier = modifier
                )
            }
        }
    }
}

@Composable
private fun TvSeriesPopular(
    statePopular: Resource<List<TvSeries>>,
    modifier: Modifier = Modifier
) {
    HomeSection(title = "TV Series Popular") {
        when (statePopular) {
            is Resource.Error -> {
                Text(text = statePopular.message ?: "Error tidak diketahui")
            }

            is Resource.Loading -> {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is Resource.Success -> {
                TvSeriesList(
                    items = statePopular.data ?: emptyList(),
                    modifier = modifier
                )
            }
        }
    }
}

