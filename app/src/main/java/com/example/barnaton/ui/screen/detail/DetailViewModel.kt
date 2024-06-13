package com.example.barnaton.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barnaton.data.Resource
import com.example.barnaton.domain.model.TvDetailSeries
import com.example.barnaton.domain.usecase.TvSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: TvSeriesUseCase
) : ViewModel() {

    private val _uiStateDetail: MutableStateFlow<Resource<TvDetailSeries>> =
        MutableStateFlow(Resource.Loading())

    val uiStateDetail: StateFlow<Resource<TvDetailSeries>> get() = _uiStateDetail

    fun getDetailData(id: Int) = viewModelScope.launch {
        useCase.getDetailFavorite(id = id).collect {
            _uiStateDetail.value = it
        }
    }
}