package com.theah64.h2x;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwipeRowUtils {

    private static final float MIN_THINKPALM_WORK_HOUR = 6;

    public static @NotNull List<SwipeRow> parseRows(@NotNull String swipeData, float funPerc) {
        final List<SwipeRow> swipeRows = new ArrayList<>();
        final String[] swipeRowStrings = swipeData.split("\n");
        for (final String swipeRow : swipeRowStrings) {
            final SwipeRow sr = parseRow(swipeRow, funPerc);
            System.out.println(sr);
            swipeRows.add(sr);
        }
        return swipeRows;
    }

    private static @NotNull SwipeRow parseRow(String swipeRow, float funPerc) {
        final String[] columns = swipeRow.split("\t");
        if (columns.length == 9) {

            //Sl.No	Requested Date	In Date	In Time	Out Date	Out Time	Worked Hours	Day Status	Temporary Card ID
            final String slNo = nullIfInvalidOrThrow(columns[0]);
            final String requestedDate = convertToXPlannerDateFormat(nullIfInvalidOrThrow(columns[1]));
            final String inDate = nullIfInvalid(columns[2]);
            final String inTime = nullIfInvalid(columns[3]);
            final String outDate = nullIfInvalid(columns[4]);
            final String outTime = nullIfInvalid(columns[5]);
            final String workedHours = nullIfInvalid(columns[6]);
            final String dayStatus = nullIfInvalidOrThrow(columns[7]);
            final String tempCardId = nullIfInvalid(columns[8]);

            return new SwipeRow(
                    slNo,
                    requestedDate,
                    dayStatus,
                    inDate,
                    inTime,
                    outDate,
                    outTime,
                    workedHours,
                    tempCardId,
                    funPerc
            );

        } else {
            throw new IllegalArgumentException("Invalid swipe lab. Column name must be 9 but got " + columns.length);
        }
    }

    private static @NotNull String convertToXPlannerDateFormat(@NotNull String date) {
        date = date.replaceAll("/", "-");
        final String[] chunks = date.split("-");
        final List<String> chunkList = Arrays.asList(chunks);
        Collections.reverse(chunkList);
        return String.join("-", chunkList);

    }

    private static String nullIfInvalidOrThrow(String data) {
        data = nullIfInvalid(data);
        if (data == null) {
            throw new IllegalArgumentException("Data shouldn't be null");
        }
        return data;
    }

    private static @Nullable String nullIfInvalid(@NotNull String data) {
        data = data.trim();
        if (data.equals("-") || data.equals("--:--")) {
            return null;
        }
        return data;
    }

    static float calcWorkedHours(@Nullable String workedHours) {

        if (workedHours == null) {
            return 0;
        }

        final String[] chunks = workedHours.split(":");

        if (chunks.length == 2) {

            final int hours = Integer.parseInt(chunks[0].trim());
            final int minutes = Integer.parseInt(chunks[1].trim());
            final int minutesInPerc = minutes > 0 ? toMinutePerc(minutes) : 0;

            return Float.parseFloat(hours + "." + minutesInPerc);

        } else {
            throw new IllegalArgumentException("Worked hours time format in wrong format " + workedHours);
        }
    }

    private static int toMinutePerc(int minutes) {
        final float x = minutes / 60f;
        return Math.round(x * 100);
    }

    static float calcFunHours(float fWorkedHours, float funPerc) {

        if (fWorkedHours < MIN_THINKPALM_WORK_HOUR) {
            // less time worked so throttling fun perc to 50%
            funPerc = funPerc - ((funPerc * 50) / 100);
        }

        return (fWorkedHours * funPerc) / 100;
    }
}
