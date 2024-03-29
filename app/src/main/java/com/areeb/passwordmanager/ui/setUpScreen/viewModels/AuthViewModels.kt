package com.areeb.passwordmanager.ui.setUpScreen.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.areeb.passwordmanager.data.Repository.AuthRepository
import com.areeb.passwordmanager.data.models.entity.PmEntity
import com.areeb.passwordmanager.data.models.entity.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModels @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    private val _user = MutableStateFlow<UserEntity?>(UserEntity(userName = "", password = ""))
    val user: StateFlow<UserEntity?> get() = _user

    private val _currentUser =
        MutableStateFlow<UserEntity?>(UserEntity(userName = "", password = ""))
    val currentUser: StateFlow<UserEntity?> get() = _currentUser

    private val _isNavigateAllowed = MutableStateFlow<Boolean>(false)
    val isNavigateAllowed = _isNavigateAllowed.asStateFlow()

    private val _passWordList = MutableStateFlow<List<PmEntity>>(emptyList())
    val passWordList: StateFlow<List<PmEntity>> get() = _passWordList


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

    fun getCurrentUser(phoneNumber: String) {
        viewModelScope.launch {
            authRepository.getCurrentUser(phoneNumber).collectLatest {
                _currentUser.value = it
            }
            _passWordList.value = _currentUser.value?.listOfPassWords ?: emptyList()
        }
    }

    fun deleteUser() {
        viewModelScope.launch {
            authRepository.deleteUser()
        }
    }

    fun updateUser(userEntity: UserEntity) {
        viewModelScope.launch {
            authRepository.updateUser(userEntity)
        }
    }
}
