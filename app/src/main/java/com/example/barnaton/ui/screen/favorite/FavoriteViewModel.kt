package com.example.barnaton.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barnaton.data.Resource
import com.example.barnaton.domain.model.TvFavorite
import com.example.barnaton.domain.usecase.TvSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val useCase: TvSeriesUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<Resource<List<TvFavorite>>> =
        MutableStateFlow(Resource.Loading())
    val uiState: StateFlow<Resource<List<TvFavorite>>>
        get() = _uiState

    fun getAllTvFavorite() = viewModelScope.launch {
        useCase.getAllTvFavorite().collect {
            _uiState.value = it
        }
    }
}