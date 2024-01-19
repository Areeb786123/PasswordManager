package com.areeb.passwordmanager.data.network.locale.dao

import androidx.room.Dao
import androidx.room.Query
import com.areeb.passwordmanager.data.models.entity.PmEntity
import com.areeb.passwordmanager.data.models.entity.UserEntity

@Dao
interface PmDao {
    @Query("SELECT * FROM passwordManagerEntity")
    suspend fun getAllPassword(): List<PmEntity>


}