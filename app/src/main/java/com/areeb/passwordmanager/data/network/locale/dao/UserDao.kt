package com.areeb.passwordmanager.data.network.locale.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.areeb.passwordmanager.data.models.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(userEntity: UserEntity)

    @Query("SELECT * FROM  userEntity")
    suspend fun getUserDetail(): UserEntity

    @Delete
    suspend fun deleteUser()
}
