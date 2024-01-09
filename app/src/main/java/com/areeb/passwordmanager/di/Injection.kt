package com.areeb.passwordmanager.di

import android.content.Context
import androidx.room.Room
import com.areeb.passwordmanager.data.AppDatabase
import com.areeb.passwordmanager.data.AppDatabase.Companion.DATA_BASE_NAME
import com.areeb.passwordmanager.data.network.locale.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Injection {
    @Provides
    @Singleton
    fun providesAppDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATA_BASE_NAME).build()
    }

    @Provides
    @Singleton
    fun providesUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}
