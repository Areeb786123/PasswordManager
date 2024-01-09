package com.areeb.passwordmanager.ui.setUpScreen.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.passwordmanager.data.Repository.AuthRepository
import com.areeb.passwordmanager.data.models.entity.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModels @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    fun saveUser(userEntity: UserEntity) {
        viewModelScope.launch {
            authRepository.saveUser(userEntity)
        }
    }

    fun getUser(userEntity: UserEntity) {
        viewModelScope.launch {
            authRepository.getUser()
        }
    }

    fun deleteUser() {
        viewModelScope.launch {
            authRepository.deleteUser()
        }
    }
}
