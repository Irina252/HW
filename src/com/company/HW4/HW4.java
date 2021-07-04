package com.company.HW4;

public class HW4 {


    public static void main(String[] args) {
        for (WeekDay day : WeekDay.values()) {
            System.out.println(day.name() + " " + day.getDayType().name());
        }
    }
}

enum DayType {
    WORK,
    DAY_OFF
}

enum WeekDay {
    MONDAY(DayType.WORK), THUESDAY(DayType.WORK), WENDSDAY(DayType.WORK), THURTUDAY(DayType.WORK), FRIDAY(DayType.WORK), SARTUDAY(DayType.DAY_OFF), SUNDAY(DayType.DAY_OFF);

    WeekDay(DayType dayType) {
        this.dayType = dayType;
    }

    private DayType dayType;

    public DayType getDayType() {
        return dayType;
    }
}