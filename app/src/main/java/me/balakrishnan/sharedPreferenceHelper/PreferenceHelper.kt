package me.balakrishnan.sharedPreferenceHelper

import android.content.Context

/**
 * Created by BalaKrishnan
 */

/**
 * This PreferenceHelper will simplify the shared preference implementation
 *
 * Currently Preference helper supports Integer, Boolean and String
 */
class PreferenceHelper(
    context: Context,
    sharedPrefName: String = context.applicationInfo.packageName
) {
    private val sharedPreferences = context.getSharedPreferences(sharedPrefName, 0)
    var userName: String by sharedPreferences.sharedPreferenceString(defaultValue = "Someone")
    var userID: Int by sharedPreferences.sharedPreferenceInt()
    var userLoggedIn: Boolean by sharedPreferences.sharedPreferenceBoolean()
}