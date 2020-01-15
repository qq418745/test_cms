package com.hjc.cms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2020-01-12 17:47
 **/
public class DateUtil {

    /**
     * 将日期转换成字符串，模版自定义
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getString(Date date, String pattern) {

        if (date == null)
            throw new IllegalArgumentException("date is null");
        if (pattern == null)
            throw new IllegalArgumentException("pattern is null");

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(date);
    }


    /**
     * 将日期转换成日期
     *
     * @param date
     *
     * @return
     */
    public static String getString(String parse,String format,String date) throws ParseException {
        return     new SimpleDateFormat(format).format(new SimpleDateFormat(parse).parse(date));
    }


    /**
     * 默认格式 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String getDefautlString(Date date) {

        String parttern = "yyyy-MM-dd";

        return getString(date, parttern);
    }

    /**
     * 返回日期指定时间 默认格式 yyyy-MM-dd
     *
     * @param date
     *            格式化出异常 格式化成 2099-12-31
     * @return
     */
    public static Date getAppointDate(String date) {
        Date tmp = null;
        if (date == null || date.equals(""))
            throw new IllegalArgumentException("date is null");
        String parttern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(parttern);
        try {
            ParsePosition pos = new ParsePosition(0);
            // String da=sdf.format(date);
            tmp = sdf.parse(date, pos);
        } catch (Exception e) {
            try {
                tmp = sdf.parse("2099-12-31");
                return tmp;
            } catch (ParseException e1) {
                e1.printStackTrace();
                return null;
            }
        }
        return tmp;
    }

    public static String getBeforeDay(String day) {
        Date date = getAppointDate(day);
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        String reday = getDefautlString(date);
        return reday;
    }

    public static String getToday(Integer num) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day);
        date = calendar.getTime();
        System.out.println("Today:" + getDefautlString(date));
        return getDefautlString(date);
    }

    public static String getDaystr(String day) {

        Date date = getAppointDate(day);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        date = calendar.getTime();
        System.out.println("Today:" + getDefautlString(date));
        return getDefautlString(date);
    }

    /**
     * 获取指定日期30天前的日期
     *
     * @param day
     * @return
     */
    public static String getBefore30Day(String day) {

        Date date = getAppointDate(day);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -29);
        date = calendar.getTime();
        System.out.println("Today:" + getDefautlString(date));
        return getDefautlString(date);
    }

    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        return date;
    }

    public static String getYestoDay() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return getDefautlString(date);
    }

    public static String getYestoDay(String day) {
        Date date = getAppointDate(day);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return getDefautlString(date);
    }

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 中国形式 ：周一开始 周末结束 获取 当前周的周末的日期
     *
     * @param num
     * @return
     */
    public static String getSunday(Integer num) {

        Date time = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式

        Calendar cal = Calendar.getInstance();

        cal.setTime(time);
        int tmp = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, tmp - 7 * num);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了

        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        if (1 == dayWeek) {

            cal.add(Calendar.DAY_OF_MONTH, -1);

        }

        // System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期

        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

        String imptimeBegin = sdf.format(cal.getTime());

        // System.out.println("所在周星期一的日期："+imptimeBegin);

        cal.add(Calendar.DATE, 6);

        String sunday = sdf.format(cal.getTime());

        // System.out.println("返回日期"+sunday);
        return sunday;
    }

    /**
     * 中国形式 ：周一开始 周末结束 获取 指定日期的周末的日期
     *
     * @param daystr
     * @return
     */
    public static String getSunday(String daystr) {

        Date time = null;
        time = getAppointDate(daystr);
        if (time == null) {
            time = new Date();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式

        Calendar cal = Calendar.getInstance();

        cal.setTime(time);
        int tmp = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, tmp);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了

        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        if (1 == dayWeek) {

            cal.add(Calendar.DAY_OF_MONTH, -1);

        }

        // System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期

        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

        String imptimeBegin = sdf.format(cal.getTime());

        // System.out.println("所在周星期一的日期："+imptimeBegin);

        cal.add(Calendar.DATE, 6);

        String sunday = sdf.format(cal.getTime());

        // System.out.println("返回日期"+sunday);
        return sunday;
    }

    /**
     * 中国形式 ：周一开始 周末结束 获取前一个周日的日期
     *
     * @return
     */
    public static String getBeforeSunday(Integer num) {

        Date time = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式

        Calendar cal = Calendar.getInstance();

        cal.setTime(time);
        int tmp = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, tmp - 7 * num);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了

        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        if (1 == dayWeek) {

            cal.add(Calendar.DAY_OF_MONTH, -1);

        }

        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期

        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

        String imptimeBegin = sdf.format(cal.getTime());

        cal.add(Calendar.DATE, -1);

        String beforesunday = sdf.format(cal.getTime());

        System.out.println("前一个周天：" + beforesunday);
        return beforesunday;
    }

    /**
     * 中国形式 ：周一开始 周末结束 获取前一个周日的日期
     *
     * @return
     */
    public static String getBeforeSunday(String daystr) {

        Date time = null;
        time = DateUtil.getAppointDate(daystr);
        if (time == null) {
            time = new Date();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式

        Calendar cal = Calendar.getInstance();

        cal.setTime(time);
        int tmp = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, tmp);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了

        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        if (1 == dayWeek) {

            cal.add(Calendar.DAY_OF_MONTH, -1);

        }

        // System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期

        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

        String imptimeBegin = sdf.format(cal.getTime());

        cal.add(Calendar.DATE, -1);

        String beforesunday = sdf.format(cal.getTime());

        System.out.println("前一个周天：" + beforesunday);
        return beforesunday;
    }

    /**
     * 中国形式 ：周一开始 周末结束 获取当前时间的周一日期
     *
     * @param
     * @return
     */
    public static String getMonday() {
        Date time = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式

        Calendar cal = Calendar.getInstance();

        cal.setTime(time);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了

        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }

        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期

        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

        String monday = sdf.format(cal.getTime());

        System.out.println("所在周星期一的日期：" + monday);
        return monday;
    }

    /**
     * 中国形式 ：周一开始 周末结束 获取当前时间的周一日期
     *
     * @param daystr
     * @return
     */
    public static String getMonday(String daystr) {

        Date time = null;
        time = getAppointDate(daystr);
        if (time == null) {
            time = new Date();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式

        Calendar cal = Calendar.getInstance();

        cal.setTime(time);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了

        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }

        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期

        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

        String monday = sdf.format(cal.getTime());

        System.out.println("所在周星期一的日期：" + monday);
        return monday;
    }

    /**
     * 获取 月最后一天 n=0当前月 ，n=1 上个月 n=2上上个月
     *
     * @param n
     * @return
     */
    public static String getMonLastDay(int n) {
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        // 设置Calendar月份数为下一个月
        n = n - 1;
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - n);
        // 设置Calendar日期为下一个月一号
        calendar.set(Calendar.DATE, 1);
        // 设置Calendar日期减一,为本月末
        calendar.add(Calendar.DATE, -1);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String lastday = format.format(calendar.getTime());
        return lastday;
    }

    /**
     * 获取 月最后一天
     *
     * @param day
     * @return
     */
    public static String getMonLastDay(String day) {
        // 获取Calendar
        Date date = null;
        date = getAppointDate(day);
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        // 设置Calendar月份数为下一个月
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.DATE, -1);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String lastday = format.format(calendar.getTime());
        return lastday;
    }

    /**
     * 获取指定日期前一个月的最后一天
     *
     * @param day
     * @return
     */
    public static String getBeforeMonLastDay(String day) {
        // 获取Calendar
        Date date = null;
        date = getAppointDate(day);
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        // 设置Calendar月份数为下一个月
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.DATE, -1);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String lastday = format.format(calendar.getTime());
        return lastday;

    }

    /**
     * 获取指定日期 的前一个月的第一天
     *
     * @param day
     * @return
     */
    public static String getBeforeMonFirstDay(String day) {
        String firstday = getMonFirstDay(getBeforeMonLastDay(day));
        return firstday;
    }

    /**
     * 获取 月 的第一天 n=0当前月 ，n=-1上个月 n=-2上上个月
     *
     * @param n
     * @return
     */
    public static String getMonFirstDay(int n) {
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        // 设置Calendar月份数为下一个月
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - n);
        // 设置Calendar日期为下一个月一号
        calendar.set(Calendar.DATE, 1);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday = format.format(calendar.getTime());
        System.out.println("firstday:" + firstday);
        return firstday;
    }

    public static String getMonFirstDay(String day) {
        // 获取Calendar
        Date date = null;
        date = getAppointDate(day);
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 设置Calendar月份数为下一个月
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        // 设置Calendar日期为下一个月一号
        calendar.set(Calendar.DATE, 1);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday = format.format(calendar.getTime());
        System.out.println("firstday:" + firstday);
        return firstday;
    }

    /**
     * 传入日期是否是当前周内的东西
     *
     * @param day
     * @return
     */
    public static boolean getWeekFlag(String day) {
        boolean flag = false;
        String tmp = getSunday(day);
        String now = getSunday(0);
        if (tmp.equals(now)) {
            flag = true;
        }
        return flag;
    }

    /**
     */
    public static boolean getMonthFlag(String day) {
        boolean flag = false;
        String tmp = getMonLastDay(day);
        String now = getMonLastDay(0);
        if (tmp.equals(now)) {
            flag = true;
        }
        return flag;
    }

    public static int getYear() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        return year;
    }

    public static int getLastYear(int last) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR) - last;
        return year;
    }

    public static void main(String[] args) {

        // String day =getMonFirstDay("2016-08-02");
        // String lastday =getMonLastDay("2016-08-22");
        // //String da=getMonLastDay(0);
        // System.out.println("lastday:"+lastday+",day :"+day);

        // String flag =getBeforeMonLastDay("2016-08-02");
        // String flag1 =getMonLastDay("2016-08-02");

        // String s = getBeforeSunday("2016-09-02");
        String dayss = // getMonFirstDay("2016-09-02");
                getBefore30Day("2016-08-31");
        int year = getLastYear(3);
        System.out.println("year:" + year + "");
        // System.out.println("s="+s);
        String a = getMonthDay("2016-08-31", "2017-08-31");
    }

    public static String getMonthDay(String startday, String endday) {
        String str = "";
        String year = endday.substring(0, 4);
        String startmonth = startday.substring(5, 7);
        String endmonth = endday.substring(5, 7);
        System.out.println("year =" + year + ",startmonth=" + startmonth + ", endmonth=" + endmonth);
        int years = Integer.parseInt(year);
        int thisyear = getYear();
        if (years > thisyear) {
            str = "*&*";
        } else {

        }
        return str;
    }

}
