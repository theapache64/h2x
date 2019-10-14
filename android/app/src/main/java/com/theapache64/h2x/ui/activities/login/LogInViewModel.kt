package com.theapache64.h2x.ui.activities.login

import android.util.Log
import androidx.lifecycle.*
import com.theapache64.h2x.data.remote.getusers.GetUsersRequest
import com.theapache64.h2x.data.remote.getusers.User
import com.theapache64.h2x.data.repositories.AuthRepository
import com.theapache64.h2x.data.repositories.UserPrefRepository
import com.theapache64.twinkill.logger.info
import com.theapache64.twinkill.network.utils.Resource
import javax.inject.Inject

class LogInViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userPrefRepository: UserPrefRepository
) : ViewModel() {

    // layout data
    var email: String
    var rememberMe: Boolean

    // activity data
    private val getUsersRequest = MutableLiveData<GetUsersRequest>()
    private val getUsersResponse = Transformations.switchMap(getUsersRequest) {
        authRepository.getUsers()
    }

    private val getUserMerger = MediatorLiveData<Resource<User>>()

    init {

        val (email, rememberMe) = userPrefRepository.getRememberMeData()

        this.email = email
        this.rememberMe = rememberMe

        // if getUser response change
        getUserMerger.addSource(getUsersResponse) { response ->

            Log.d("X", "Change occurred to loginResponse ${response.status}")

            if (response.status == Resource.Status.SUCCESS) {
                // logged in, save theUser
                // finding user with same email
                val user = response.data!!.find {
                    it.email == this.email
                }

                info("User is $user")

                if (user != null) {
                    userPrefRepository.saveUser(user, this.rememberMe)
                    getUserMerger.value = Resource.success(user)
                } else {
                    getUserMerger.value = Resource.error("Invalid email")
                }
            } else {
                getUserMerger.value = Resource.Companion.create(
                    response.status,
                    null,
                    response.message
                )
            }

        }
    }

    fun doLogIn() {

        // small validation
        if (this.email.trim().isEmpty()) {
            getUserMerger.value = Resource.error("Invalid credentials")
            return
        }

        info("email id $email")

        getUsersRequest.value = GetUsersRequest()
    }

    fun getUser(): LiveData<Resource<User>> = getUserMerger


}