package com.theah64.h2x

object CU {
    @JvmStatic
    fun hyphenIfNull(data: String?): String {
        return data ?: "-"
    }
}
