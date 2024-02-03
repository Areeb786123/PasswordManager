package com.areeb.passwordmanager.data.Repository

import com.areeb.passwordmanager.data.AppDatabase
import com.areeb.passwordmanager.data.models.entity.PmEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PMRepository @Inject constructor(private val appDatabase: AppDatabase) {
    suspend fun insertCredentials(pmEntity: PmEntity) {
        try {
            appDatabase.pmDao().addCredentials(pmEntity)
        } catch (e: Exception) {
            println(e.printStackTrace())
        }
    }
    suspend fun updateCredentials(pmEntity: PmEntity) {
        try {
            appDatabase.pmDao().updateCredentials(pmEntity)
        } catch (e: Exception) {
            println(e.printStackTrace())
        }
    }

    suspend fun deleteCredentials(pmEntity: PmEntity) {
        try {
            appDatabase.pmDao().deleteCredentials(pmEntity)
        } catch (e: Exception) {
            println(e.printStackTrace())
        }
    }

    fun getAllCredentials(): Flow<List<PmEntity>> {
        return flow {
            try {
                val data = appDatabase.pmDao().getAllPassword()
                emit(data)
            } catch (e: Exception) {
                println(e.printStackTrace())
            }
        }.flowOn(Dispatchers.IO)
    }
}