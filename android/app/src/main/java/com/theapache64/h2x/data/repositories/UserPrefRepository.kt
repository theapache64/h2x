package com.theapache64.h2x.data.repositories

import android.content.SharedPreferences
import androidx.core.content.edit
import com.squareup.moshi.Moshi
import com.theapache64.h2x.data.remote.getusers.User
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserPrefRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val moshi: Moshi
) {

    /**
     * Getting remember me data from shared preference
     */
    fun getRememberMeData(): Pair<String, Boolean> {

        val email = sharedPreferences.getString(KEY_EMAIL, "")!!
        val rememberMe = sharedPreferences.getBoolean(KEY_REMEMBER_ME, false)

        return Pair(email, rememberMe)
    }

    /**
     * Getting user from shared pref
     */
    fun getUser(): User? {

        // getting json theUser string from pref
        val userJson: String? = sharedPreferences.getString(User.KEY, null)
        var user: User? = null
        if (userJson != null) {
            // converting JSON to Model
            val moshiAdapter = moshi.adapter(User::class.java)
            user = moshiAdapter.fromJson(userJson)
        }

        return user
    }

    /**
     * Saves theUser object to shared pref
     */
    fun saveUser(user: User, isRememberMe: Boolean) {
        sharedPreferences.edit {
            val moshiAdapter = moshi.adapter(User::class.java)
            val userJson = moshiAdapter.toJson(user)
            putString(User.KEY, userJson)

            if (isRememberMe) {
                putString(KEY_EMAIL, user.email)
            }
        }
    }

    /**
     * Clear user data from preference
     */
    fun clearUser() {
        sharedPreferences.edit {
            putString(User.KEY, null)
        }
    }


    companion object {
        const val KEY_EMAIL = "email"
        const val KEY_REMEMBER_ME = "remember_me"
    }
}