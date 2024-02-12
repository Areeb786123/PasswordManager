package com.areeb.passwordmanager.data.Repository

import android.util.Log
import com.areeb.passwordmanager.data.AppDatabase
import com.areeb.passwordmanager.data.models.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AuthRepository @Inject constructor(private val appDatabase: AppDatabase) {

    companion object {
        private val TAG = "authRepo"
    }

    suspend fun saveUser(userEntity: UserEntity) {
        try {
            appDatabase.userDao().addUser(userEntity)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

    suspend fun deleteUser() {
        try {
            appDatabase.userDao().deleteUser()
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

    fun getUser(): Flow<UserEntity?> {
        return flow {
            try {
                val data = appDatabase.userDao().getUserDetail()
                emit(data)
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getCurrentUser(phoneNumber: String): Flow<UserEntity?> {
        return flow {
            try {
                val user = appDatabase.userDao().getCurrentUser(phoneNumber)
                emit(user)
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}
