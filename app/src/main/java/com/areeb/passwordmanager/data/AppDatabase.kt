package com.areeb.passwordmanager.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.areeb.passwordmanager.data.models.entity.UserEntity
import com.areeb.passwordmanager.data.network.locale.dao.UserDao

@Database(entities = [UserEntity::class], version = AppDatabase.VERSION_ONE)
abstract class AppDatabase :RoomDatabase() {
    companion object {
        const val VERSION_ONE = 1
        const val DATA_BASE_NAME = "passManagerDB"
    }

    abstract fun userDao(): UserDao
}
