package me.balakrishnan.sharedPreferenceHelper

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


private class LongPreference(
    private val sharedPreferences: SharedPreferences,
    private val defaultValue: Long
) : ReadWriteProperty<Any, Long> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Long =
        sharedPreferences.getLong(property.name, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) {
        sharedPreferences.edit()
            .putLong(property.name, value)
            .apply()
    }
}

private class IntPreference(
    private val sharedPreferences: SharedPreferences,
    private val defaultValue: Int
) : ReadWriteProperty<Any, Int> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Int =
        sharedPreferences.getInt(property.name, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        sharedPreferences.edit()
            .putInt(property.name, value)
            .apply()
    }
}

private class BooleanPreference(
    private val sharedPreferences: SharedPreferences,
    private val defaultValue: Boolean
) : ReadWriteProperty<Any, Boolean> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean {
        return sharedPreferences.getBoolean(property.name, defaultValue)
    }


    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
        sharedPreferences.edit()
            .putBoolean(property.name, value)
            .apply()
    }
}

private class StringPreference(
    private val sharedPreferences: SharedPreferences,
    private val defaultValue: String
) : ReadWriteProperty<Any, String> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return sharedPreferences.getString(property.name, defaultValue)!!
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        sharedPreferences.edit().putString(property.name, value).apply()
    }
}


fun SharedPreferences.sharedPreferenceInt(
    defaultValue: Int = 0
): ReadWriteProperty<Any, Int> =
    IntPreference(this, defaultValue)

fun SharedPreferences.sharedPreferenceBoolean(
    defaultValue: Boolean = false
): ReadWriteProperty<Any, Boolean> =
    BooleanPreference(this, defaultValue)

fun SharedPreferences.sharedPreferenceString(
    defaultValue: String = ""
): ReadWriteProperty<Any, String> =
    StringPreference(this, defaultValue)

fun SharedPreferences.sharedPreferenceLong(
    defaultValue: Long = 0L
): ReadWriteProperty<Any, Long> =
    LongPreference(this, defaultValue)