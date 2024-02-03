package com.areeb.passwordmanager.data.network.locale.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.areeb.passwordmanager.data.models.entity.PmEntity
import com.areeb.passwordmanager.data.models.entity.UserEntity

@Dao
interface PmDao {
    @Query("SELECT * FROM passwordManagerEntity")
    suspend fun getAllPassword(): List<PmEntity>

    @Insert
    suspend fun addCredentials(pmEntity: PmEntity)

    @Delete
    suspend fun deleteCredentials(pmEntity: PmEntity)

    @Update
    suspend fun updateCredentials(pmEntity: PmEntity)

}