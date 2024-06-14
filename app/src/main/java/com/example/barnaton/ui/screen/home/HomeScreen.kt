package com.example.barnaton.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.barnaton.data.Resource
import com.example.barnaton.domain.model.TvSeries
import com.example.barnaton.ui.components.Banner
import com.example.barnaton.ui.components.HomeSection
import com.example.barnaton.ui.components.TvSeriesList
import com.example.barnaton.ui.components.TvSeriesListSearch
import com.example.barnaton.ui.theme.midNightBlue

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    navigateToDetail: ((Int) -> Unit)? = null
) {
    LaunchedEffect(Unit) {
        viewModel.getAllOnAir()
        viewModel.getAllPopular()
        viewModel.getAllTopRated()
    }
    val stateOnAir by viewModel.uiStateOnAir.collectAsState()
    val statePopular by viewModel.uiStatePopular.collectAsState()
    val stateTopRated by viewModel.uiStateTopRated.collectAsState()
    val stateOnSearch by viewModel.uiStateOnSearch.collectAsState()
//    val stateQuery by viewModel.stateQuery.collectAsState()

    var stateQuery by remember { mutableStateOf("") }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(midNightBlue)
    ) {
        LazyColumn {
            item {
                Banner(
                    onSearch = {
                        if (it.isNotBlank()) {
                            stateQuery = it
                            viewModel.getAllOnSearch(it)
                        } else {
                            stateQuery = ""
                            viewModel.getAllOnAir()
                            viewModel.getAllPopular()
                            viewModel.getAllTopRated()
                        }
                    }
                )
            }
            if(stateQuery.isBlank()) {
                item {
                    TVSeriesOnAir(stateOnAir = stateOnAir, navigateToDetail = navigateToDetail)
                }
                item {
                    TvSeriesPopular(statePopular = statePopular, navigateToDetail = navigateToDetail)
                }
                item {
                    TVSeriesTopRated(stateTopRated = stateTopRated, navigateToDetail = navigateToDetail)
                }
            } else {
                item {
                    TVSeriesOnSearch(stateOnSearch = stateOnSearch, navigateToDetail = navigateToDetail)
                }
            }
        }
    }
}

@Composable
private fun TVSeriesOnSearch(
    stateOnSearch: Resource<List<TvSeries>>,
    modifier: Modifier = Modifier,
    navigateToDetail: ((Int) -> Unit)? = null
) {
    HomeSection(title = "TV Series On Search") {
        when (stateOnSearch) {
            is Resource.Error -> {
                Text(text = stateOnSearch.message ?: "Error tidak diketahui")
            }

            is Resource.Loading -> {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is Resource.Success -> {
                TvSeriesListSearch(
                    items = stateOnSearch.data ?: emptyList(),
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}

@Composable
private fun TVSeriesOnAir(
    stateOnAir: Resource<List<TvSeries>>,
    modifier: Modifier = Modifier,
    navigateToDetail: ((Int) -> Unit)? = null
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
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}

@Composable
private fun TVSeriesTopRated(
    stateTopRated: Resource<List<TvSeries>>,
    modifier: Modifier = Modifier,
    navigateToDetail: ((Int) -> Unit)? = null
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
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}

@Composable
private fun TvSeriesPopular(
    statePopular: Resource<List<TvSeries>>,
    modifier: Modifier = Modifier,
    navigateToDetail: ((Int) -> Unit)? = null
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
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}

