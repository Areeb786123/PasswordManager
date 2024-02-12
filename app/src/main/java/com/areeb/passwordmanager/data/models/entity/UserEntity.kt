package com.areeb.passwordmanager.data.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.areeb.passwordmanager.data.converters.Converters

@Entity(tableName = "userEntity")
@TypeConverters(Converters::class)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userName: String? = null,
    val password: String? = null,
    val phoneNumber: String? = null,
    val listOfPassWords: List<PmEntity>? = emptyList()
)
