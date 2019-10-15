package com.theapache64.h2x.data.remote.getprefs

import com.squareup.moshi.Json

data class Pref(
    @Json(name = "per_day")
    val perDay: Float, // 0.33
    @Json(name = "per_section")
    val perSection: Float // 3.5
)