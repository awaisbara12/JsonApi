package com.example.jsonapi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonapi.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetRepository) :ViewModel() {

    val categories : StateFlow<List<String>>
        get() = repository.catogories

    init {
        viewModelScope.launch {
            repository.getCateories()
        }
    }
}