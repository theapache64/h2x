package com.theapache64.h2x.ui.activities.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.theapache64.h2x.BuildConfig
import com.theapache64.h2x.data.repositories.UserPrefRepository
import com.theapache64.h2x.ui.activities.form.FormActivity
import com.theapache64.h2x.ui.activities.login.LogInActivity
import com.theapache64.twinkill.utils.livedata.SingleLiveEvent
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val userPrefRepository: UserPrefRepository
) : ViewModel() {

    val versionName = "v${BuildConfig.VERSION_NAME}"

    private val launchActivityEvent = SingleLiveEvent<Int>()

    fun getLaunchActivityEvent(): LiveData<Int> {
        return launchActivityEvent
    }

    fun goToNextScreen() {

        val user = userPrefRepository.getUser()
        val activityId = if (user == null) LogInActivity.ID else FormActivity.ID

        Log.i(TAG, "User is ${user?.email}")


        // passing id with the finish notification
        launchActivityEvent.value = activityId
    }

    companion object {
        val TAG = SplashViewModel::class.java.simpleName
    }

}