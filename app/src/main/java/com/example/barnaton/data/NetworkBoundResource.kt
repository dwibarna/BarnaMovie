package com.example.barnaton.data

import com.example.barnaton.data.remote.network.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType> {

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when(val apiResponse = createCall().first()) {
            is ApiResponse.Error -> {
                emit(Resource.Error(message = apiResponse.message))
            }
            is ApiResponse.Success -> {
                saveCallResult(apiResponse.data)
                emitAll(
                    loadFromDB().map {
                        Resource.Success(it)
                    }
                )
            }
        }
    }
}