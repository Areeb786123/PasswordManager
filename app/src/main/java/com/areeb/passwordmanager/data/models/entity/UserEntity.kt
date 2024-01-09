package com.areeb.passwordmanager.data.models.entity

import androidx.room.Entity

@Entity(tableName = "userEntity")
data class UserEntity(
    val userName: String,
    val password: String,
)
