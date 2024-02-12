package com.areeb.passwordmanager.utils.sharedPreferences

import android.content.Context
import com.areeb.passwordmanager.utils.StringConstant.Companion.PHONE_NUMBER
import com.areeb.passwordmanager.utils.StringConstant.Companion.PIN
import com.areeb.passwordmanager.utils.StringConstant.Companion.SHARED_PREFERENCES

object GetSharedPreferences {

    fun setPin(context: Context, pin: Int) {
        val sp = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        sp.edit().putInt(PIN, pin).apply()
    }

    fun getPin(context: Context): Int {
        val sp = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        return sp.getInt(PIN, 0)
    }
    fun setPhoneNumber(context: Context, phoneNumber: Long) {
        val sp = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        sp.edit().putLong(PHONE_NUMBER, phoneNumber ).apply()
    }

    fun getPhoneNumber(context: Context): Long {
        val sp = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        return sp.getLong(PHONE_NUMBER, 0)
    }
}