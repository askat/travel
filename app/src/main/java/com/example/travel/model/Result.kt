package com.example.travel.model

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data object Loading : Result<Nothing>()
}