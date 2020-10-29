package com.peto.canopy.justdoit;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SomeCalendarAscii {
    public static void main(String[] args) {
        testCal();
    }

    private static void testCal() {

        System.out.println("::::::::::::SyncMeterDateTimeForIskraMT83X Object:::::::::");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(sdf.format(cal.getTime()));
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
//int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

//        System.out.println(year + " " + (month + 1) + " " + day + " " + hour + " " + minute + " " + second);

        StringBuilder stringDateBuilder = new StringBuilder();
        stringDateBuilder.append(year);
        stringDateBuilder.append(month + 1);
        stringDateBuilder.append(day);
        stringDateBuilder.append(hour);
        stringDateBuilder.append(minute);
        stringDateBuilder.append(second);

        // verify data from email
        System.out.println("verify email data == Date in ACII Format -> " + "200904113455" +" | in Hex -> "+toHexStr("200904113455"));

        System.out.println("Date in ACII Format -> " + stringDateBuilder.toString() +" | in Hex -> "+toHexStr(stringDateBuilder.toString()));
    }

    public static String toHexStr(String str) {
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            String hexString = Integer.toHexString(c);
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String toHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
    }
}
