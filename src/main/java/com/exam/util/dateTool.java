package com.exam.util;

import java.util.Date;

public class dateTool {
    public static long getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
       // 计算差多少天
        long day = diff / nd;
       // 计算差多少小时
        long hour = diff % nd / nh;
       // 计算差多少分钟
        long min = diff / 1000 % 60;
      // 计算差多少秒//输出结果
      // long sec = diff % nd % nh % nm / ns;
        return day*24*60 + hour*60 + min;
    }
    /*public static void main(String [] arg) throws ParseException {
        Date date = new Date();// 创建Date类型对象

        // 创建SimpleDateFormat类型对象、 "yyyy-MM-dd HH:ss:mm.SSS"是正则式，分别表示年月日时分秒毫秒
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");

        // 定义两个时间
        String startTime = "2018-8-20 00:01:00";
        String endTime = "2018-8-21 20:00:00";

        // 将两个String类型的时间转换为Date类型，从而计算差值、parse()方法的作用是将String类型的时间解析为Date类型
        Date d1 = df.parse(startTime);
        Date d2 = df.parse(endTime);

        System.out.println(dateTool.getDatePoor(d2,d1));
    }*/
}
