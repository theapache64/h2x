package com.theapache64.h2x.data.remote.getusers

import com.squareup.moshi.Json


/**
 * Generated using MockAPI (https://github.com/theapache64/Mock-API) : Wed Jan 16 14:49:46 UTC 2019
 */
data class User(
    @Json(name = "email")
    val email: String, // vineeth.s@thinkpalm.com
    @Json(name = "heads_password")
    val headsPassword: String, // pass
    @Json(name = "heads_username")
    val headsUsername: String, // ITP 1418
    @Json(name = "xplanner_id")
    val xplannerId: Int, // 642060
    @Json(name = "xplanner_password")
    val xplannerPassword: String // Admin@123
) {
    companion object {
        const val KEY = "user"
    }
}