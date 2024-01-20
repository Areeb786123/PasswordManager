package com.areeb.passwordmanager.data.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.areeb.passwordmanager.utils.StringConstant.Companion.PASSWORD_MANAGER_ENTITY

@Entity(tableName = "passwordManagerEntity")
data class PmEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val appName: String,
    val email: String,
    val password: String,
)