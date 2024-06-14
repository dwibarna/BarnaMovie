package com.example.barnaton.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barnaton.data.Resource
import com.example.barnaton.domain.model.TvDetailSeries
import com.example.barnaton.domain.model.TvFavorite
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

    private  val _stateItemFavorite: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val stateItemFavorite: StateFlow<Boolean> get() = _stateItemFavorite

    fun getStateItemFavorite(boolean: Boolean) = viewModelScope.launch {
        _stateItemFavorite.value = boolean
    }

    fun getDetailData(id: Int) = viewModelScope.launch {
        useCase.getDetailFavorite(id = id).collect {
            _uiStateDetail.value = it
        }
    }

    fun insertTvFavorite(entity: TvFavorite) = viewModelScope.launch {
        useCase.insertTvFavorite(entity)
    }

    fun deleteTvFavorite(id: Int) = viewModelScope.launch {
        useCase.deleteTvFavorite(id = id)
    }

    fun getTvFavorite(id: Int): TvFavorite {
        return useCase.getTvFavorite(id = id)
    }
}