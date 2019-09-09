package com.ynet.empdoc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer {
    public static String getTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return  simpleDateFormat.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(Timer.getTime());
    }
}
