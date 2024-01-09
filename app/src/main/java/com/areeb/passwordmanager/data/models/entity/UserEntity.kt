package com.areeb.passwordmanager.data.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userEntity")
data class UserEntity(
    @PrimaryKey (autoGenerate = true)
    val id: Long,
    val userName: String,
    val password: String,
)
