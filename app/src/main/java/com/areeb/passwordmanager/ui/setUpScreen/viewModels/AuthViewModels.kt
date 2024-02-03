package com.areeb.passwordmanager.ui.setUpScreen.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.passwordmanager.data.Repository.AuthRepository
import com.areeb.passwordmanager.data.models.entity.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModels @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    private val _user = MutableStateFlow<UserEntity>(UserEntity(userName = "", password = ""))
    val user: StateFlow<UserEntity> get() = _user

    init {
        getUser()
    }

    fun saveUser(userEntity: UserEntity) {
        viewModelScope.launch {
            authRepository.saveUser(userEntity)
        }
    }

    fun getUser() {
        viewModelScope.launch {
            authRepository.getUser().collectLatest {
                _user.value = it
            }
        }
    }

    fun deleteUser() {
        viewModelScope.launch {
            authRepository.deleteUser()
        }
    }
}
