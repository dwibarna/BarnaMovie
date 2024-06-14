package com.example.barnaton.ui.screen.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.barnaton.data.Resource
import com.example.barnaton.ui.components.HomeSection
import com.example.barnaton.ui.components.TvSeriesFavoriteList
import com.example.barnaton.ui.theme.midNightBlue

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = viewModel(),
    modifier: Modifier = Modifier,
    navigateToDetail: ((Int) -> Unit)? = null
) {
    LaunchedEffect(Unit) {
        viewModel.getAllTvFavorite()
    }
    val stateUi by viewModel.uiState.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(midNightBlue)
    ) {
        HomeSection(title = "Favorite List") {
            when(stateUi) {
                is Resource.Error -> {
                    Text(text = stateUi.message ?: "Error tidak diketahui")
                }
                is Resource.Loading -> {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is Resource.Success -> {
                    TvSeriesFavoriteList(
                        items = stateUi.data ?: emptyList(),
                        navigateToDetail = navigateToDetail
                    )
                }
            }
        }
    }
}