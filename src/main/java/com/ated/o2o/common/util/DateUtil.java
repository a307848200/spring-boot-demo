package com.ated.o2o.common.util;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 时间工具
 * @author zengwx
 * @date 2017年10月11日
 * @version 1.0
 * @remark
 */
public class DateUtil {


    /**
     * 根据年月日 创建日期
     *
     * @param year  年 2018
     * @param month 月 05
     * @param day   日 4
     * @return LocalDate 2018-05-04
     */
    public static LocalDate getDay(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    /**
     * 获取当月某一天
     *
     * @param localDate LocalDate 2018-05-04
     * @param day       第几天   8
     * @return LocalDate 2018-05-08
     */
    public static LocalDate getDayOfMonth(LocalDate localDate, int day) {
        return localDate.withDayOfMonth(day);
    }

    /**
     * 获取某月最后一天
     *
     * @param localDate LocalDate 2018-05-04
     * @return LocalDate  2018-05-31
     */
    public static LocalDate getLastDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * LocalDate转Date
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * Date转LocalDate
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    public static void main(String[] args) {
    }
}
