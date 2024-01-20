package com.areeb.passwordmanager.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModels @Inject constructor()  :ViewModel(){
    private val _query = MutableStateFlow<String>("")
    val query: StateFlow<String> get() = _query

    fun setQuery(query: String) {
        _query.value = query
    }
}