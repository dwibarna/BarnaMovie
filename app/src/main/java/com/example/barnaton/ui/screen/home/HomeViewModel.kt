package com.example.barnaton.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barnaton.data.Resource
import com.example.barnaton.domain.model.TvSeries
import com.example.barnaton.domain.usecase.TvSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: TvSeriesUseCase
) : ViewModel() {

    private val _uiStatePopular: MutableStateFlow<Resource<List<TvSeries>>> =
        MutableStateFlow(Resource.Loading())
    val uiStatePopular: StateFlow<Resource<List<TvSeries>>>
        get() = _uiStatePopular


    private val _uiStateTopRated: MutableStateFlow<Resource<List<TvSeries>>> =
        MutableStateFlow(Resource.Loading())
    val uiStateTopRated: StateFlow<Resource<List<TvSeries>>>
        get() = _uiStateTopRated


    private val _uiStateOnAir: MutableStateFlow<Resource<List<TvSeries>>> =
        MutableStateFlow(Resource.Loading())
    val uiStateOnAir: StateFlow<Resource<List<TvSeries>>>
        get() = _uiStateOnAir

    fun getAllPopular() = viewModelScope.launch {
        useCase.getAllPopular().collect {
            _uiStatePopular.value = it
        }
    }

    fun getAllTopRated() = viewModelScope.launch {
        useCase.getAllTopRated().collect {
            _uiStateTopRated.value = it
        }
    }

    fun getAllOnAir() = viewModelScope.launch {
        useCase.getAllOnAir().collect {
            _uiStateOnAir.value = it
        }
    }
}*/
