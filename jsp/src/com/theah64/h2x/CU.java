package com.theah64.h2x;

import org.jetbrains.annotations.Nullable;

public class CU {
    public static String hyphenIfNull(@Nullable String data) {
        if (data == null) {
            return "-";
        }
        return data;
    }
}
