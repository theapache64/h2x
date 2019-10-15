package com.theapache64.h2x.data.remote


import androidx.lifecycle.LiveData
import com.theapache64.h2x.data.remote.getprefs.Pref
import com.theapache64.h2x.data.remote.getusers.User
import com.theapache64.twinkill.network.utils.Resource
import retrofit2.http.GET


/**
 * To hold all API methods
 */
interface ApiInterface {

    @GET("2167e349-474c-4368-b297-a14f447850a2")
    fun getUsers(): LiveData<Resource<List<User>>>

    @GET("534577c0-843d-4b03-a534-032473c0f69c")
    fun getPrefs(): LiveData<Resource<List<Pref>>>

}

