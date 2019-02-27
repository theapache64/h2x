package com.theah64.h2x;

import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class H2X {
    public static final String KEY_XP_ID = "xp_id";
    public static final String KEY_SWIPE_DATA = "swipe_data";
    public static final String KEY_FUN_PERC = "fun_perc";

    public static @NotNull List<SwipeRow> getSwipeRows(HttpServletResponse response, String xpId, String swipeData, String funPerc) throws IOException {

        if (xpId == null || xpId.trim().isEmpty() ||
                swipeData == null || swipeData.trim().isEmpty() ||
                funPerc == null || funPerc.trim().isEmpty()
        ) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
            return null;
        }

        final float funPercFloat = Float.parseFloat(funPerc);
        return SwipeRowUtils.parseRows(swipeData, funPercFloat);
    }
}
