package com.theapache64.h2x.data.repositories

import androidx.lifecycle.LiveData
import com.theapache64.h2x.data.remote.ApiInterface
import com.theapache64.h2x.data.remote.getusers.User
import com.theapache64.twinkill.network.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {

    /**
     * To do API call to getUser route
     */
    fun getUsers(): LiveData<Resource<List<User>>> = apiInterface.getUsers()
}