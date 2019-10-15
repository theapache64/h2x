package com.theapache64.h2x.data.repositories

import com.theapache64.h2x.data.remote.ApiInterface
import javax.inject.Inject

class ServerPrefRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {
    fun getPrefs() = apiInterface.getPrefs()
}