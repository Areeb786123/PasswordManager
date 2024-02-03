package com.areeb.passwordmanager.ui.addPassword.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.passwordmanager.data.Repository.PMRepository
import com.areeb.passwordmanager.data.models.entity.PmEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddDataViewModels @Inject constructor(private val pmRepository: PMRepository) : ViewModel() {
    private val _allCredentials = MutableStateFlow<List<PmEntity>>(emptyList())
    val allCredentials: StateFlow<List<PmEntity>> get() = _allCredentials

    companion object {
        private val TAG = "addDataViewModels"
    }

    private fun getAllCredentials() {
        viewModelScope.launch {
            pmRepository.getAllCredentials().collectLatest {
                _allCredentials.value = it
            }
        }
    }

    fun addCredentials(pmEntity: PmEntity) {
        viewModelScope.launch {
            try {
                pmRepository.insertCredentials(pmEntity)

            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }

    fun updateCredentials(pmEntity: PmEntity) {
        viewModelScope.launch {
            try {
                pmRepository.updateCredentials(pmEntity)

            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }

    fun deleteCredentials(pmEntity: PmEntity) {
        viewModelScope.launch {
            try {
                pmRepository.deleteCredentials(pmEntity)

            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }
}