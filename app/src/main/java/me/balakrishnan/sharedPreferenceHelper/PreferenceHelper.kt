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
class PreferenceHelper(context: Context) {
    var userName: String by context.sharedPreferenceString()
    var userID: Int by context.sharedPreferenceInt()
    var userLoggedIn: Boolean by context.sharedPreferenceBoolean()
}