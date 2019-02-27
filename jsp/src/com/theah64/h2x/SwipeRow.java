package com.theah64.h2x;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SwipeRow {

    private final @NotNull String slNo;
    private final @NotNull String requestedDate;
    private final @NotNull String dayStatus;

    private final @Nullable String inDate;
    private final @Nullable String inTime;
    private final @Nullable String outDate;
    private final @Nullable String outTime;
    private final @Nullable String workedHours;
    private final @Nullable String temporaryCardId;
    private final float fWorkedHours;
    private final float fFunHours;
    private final float fNetWorkedHours;
    private final float funPerc;


    public SwipeRow(
            @NotNull String slNo,
            @NotNull String requestedDate,
            @NotNull String dayStatus,
            @Nullable String inDate,
            @Nullable String inTime,
            @Nullable String outDate,
            @Nullable String outTime,
            @Nullable String workedHours,
            @Nullable String temporaryCardId,
            float funPerc
    ) {
        this.slNo = slNo;
        this.requestedDate = requestedDate;
        this.dayStatus = dayStatus;
        this.inDate = inDate;
        this.inTime = inTime;
        this.outDate = outDate;
        this.outTime = outTime;
        this.workedHours = workedHours;
        this.temporaryCardId = temporaryCardId;
        this.fWorkedHours = SwipeRowUtils.calcWorkedHours(workedHours);
        this.funPerc = (inDate == null && outDate == null) ? 0 : funPerc;
        this.fFunHours = SwipeRowUtils.calcFunHours(fWorkedHours, this.funPerc);
        this.fNetWorkedHours = fWorkedHours - fFunHours;
    }


    @NotNull
    public String getSlNo() {
        return slNo;
    }

    @NotNull
    public String getRequestedDate() {
        return requestedDate;
    }

    @NotNull
    public String getDayStatus() {
        return dayStatus;
    }

    @Nullable
    public String getInDate() {
        return inDate;
    }

    @Nullable
    public String getInTime() {
        return inTime;
    }

    @Nullable
    public String getOutDate() {
        return outDate;
    }

    @Nullable
    public String getOutTime() {
        return outTime;
    }

    @Nullable
    public String getWorkedHours() {
        return workedHours;
    }

    @Nullable
    public String getTemporaryCardId() {
        return temporaryCardId;
    }

    public float getfWorkedHours() {
        return fWorkedHours;
    }

    public float getfFunHours() {
        return fFunHours;
    }

    public float getfNetWorkedHours() {
        return fNetWorkedHours;
    }

    public float getFunPerc() {
        return funPerc;
    }

    @Override
    public String toString() {
        return "SwipeRow{" +
                "slNo='" + slNo + '\'' +
                ", requestedDate='" + requestedDate + '\'' +
                ", dayStatus='" + dayStatus + '\'' +
                ", inDate='" + inDate + '\'' +
                ", inTime='" + inTime + '\'' +
                ", outDate='" + outDate + '\'' +
                ", outTime='" + outTime + '\'' +
                ", workedHours='" + workedHours + '\'' +
                ", temporaryCardId='" + temporaryCardId + '\'' +
                ", fWorkedHours=" + fWorkedHours +
                ", fFunHours=" + fFunHours +
                ", fNetWorkedHours=" + fNetWorkedHours +
                '}';
    }
}
