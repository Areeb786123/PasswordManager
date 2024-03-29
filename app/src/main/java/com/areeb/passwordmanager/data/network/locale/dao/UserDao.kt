package com.areeb.passwordmanager.data.network.locale.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.areeb.passwordmanager.data.models.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(userEntity: UserEntity)

    @Query("SELECT * FROM userEntity")
    suspend fun getUserDetail(): UserEntity

    @Query("SELECT * FROM userEntity WHERE phoneNumber = :phoneNumber")
    suspend fun getCurrentUser(phoneNumber: String): UserEntity?

    @Query("DELETE FROM userEntity")
    suspend fun deleteUser()

    @Update
    suspend fun updateUser(userEntity: UserEntity)
}
