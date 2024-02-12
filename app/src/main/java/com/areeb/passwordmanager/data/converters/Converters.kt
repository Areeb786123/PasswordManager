package com.areeb.passwordmanager.data.converters

import androidx.room.TypeConverter
import com.areeb.passwordmanager.data.models.entity.PmEntity
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromString(value: String): List<PmEntity> {
        val listType = object : TypeToken<List<PmEntity>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<PmEntity>): String {
        return Gson().toJson(list)
    }
}