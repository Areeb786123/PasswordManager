package com.areeb.passwordmanager.data.Repository

import android.util.Log
import com.areeb.passwordmanager.data.AppDatabase
import com.areeb.passwordmanager.data.models.entity.UserEntity
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

    suspend fun getUser() {
        try {
            appDatabase.userDao().getUserDetail()
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }
}
