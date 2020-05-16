package me.balakrishnan.sharedPreferenceHelper

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private class IntPreference(
        private val context: Context,
        private val name: String = context.applicationInfo.packageName,
        private val defaultValue: Int
) : ReadWriteProperty<Any, Int> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Int =
            context.getSharedPreferences(name, 0).getInt(property.name, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        context.getSharedPreferences(name, 0).edit()
                .putInt(property.name, value)
                .apply()
    }
}

private class BooleanPreference(
        private val context: Context,
        private val name: String,
        private val defaultValue: Boolean
) : ReadWriteProperty<Any, Boolean> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean {
        return context.getSharedPreferences(name, 0).getBoolean(property.name, defaultValue)
    }


    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
        context.getSharedPreferences(name, 0).edit()
                .putBoolean(property.name, value)
                .apply()
    }
}

private class StringPreference(
        private val context: Context,
        private val name: String,
        private val defaultValue: String
) : ReadWriteProperty<Any, String> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        val sharedPreferences = context.getSharedPreferences(name, 0)
        return sharedPreferences.getString(property.name, defaultValue)!!
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        val sharedPreferences = context.getSharedPreferences(name, 0)
        sharedPreferences.edit().putString(property.name, value).apply()
    }
}

fun Context.sharedPreferenceInt(
        defaultValue: Int = 0,
        appPackageName: String = this.applicationInfo.packageName
): ReadWriteProperty<Any, Int> =
        IntPreference(this, appPackageName, defaultValue)

fun Context.sharedPreferenceBoolean(
        defaultValue: Boolean = false,
        appPackageName: String = this.applicationInfo.packageName
): ReadWriteProperty<Any, Boolean> =
        BooleanPreference(this, appPackageName, defaultValue)

fun Context.sharedPreferenceString(
        defaultValue: String = "",
        appPackageName: String = this.applicationInfo.packageName
): ReadWriteProperty<Any, String> =
        StringPreference(this, appPackageName, defaultValue)