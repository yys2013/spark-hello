package com.fdc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static final String DATETIME_FORMAT      = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT          = "yyyy-MM-dd";
    public static final String DATE_FORMAT2         = "yyyyMMdd";
    
    //年月
    public static final String YEAR_MONTH_FORMAT     = "yyyy-MM";
    public static final String YEAR_MONTH_FORMAT2    = "yyyyMM";
    public static final String YEAR_MONTH_FORMAT3    = "yyyy年MM月";
    public static final String YEAR_MONTH_FORMAT4    = "yyMM";
    
    
    /**
     * Adds a number of days to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     */
    public static Date addDays(Date date, int amount) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, amount);
        return calendar.getTime();
    }
    
    /**
     * @param date
     * @param amount
     * @return Date
     */
    public static Date addMonths(Date date, int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, amount);
        return calendar.getTime();
    }
    
    /**
     * 字符串转换为日期
     * 
     * @param dateString
     *            日期格式字符串
     * @param sf
     *            日期格式化定义
     * @return 转换后的日期
     */
    public static Date stringToDate(String dateString, String sf) {
        try {
            DateFormat sdf = new SimpleDateFormat(sf);
            Date dt = sdf.parse(dateString);
            return dt;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 字符串转换为日期
     * 
     * @param dateString
     *            yyyy-MM-dd HH:mm:ss
     * @return 日期
     */
    public static Date stringToDate(String dateString) {
            Date dt = stringToDate(dateString, DATETIME_FORMAT);
            return dt;
    }

    /**
     * 字符串转换为日期
     * 
     * @param dateString
     *            yyyy-MM-dd
     * @return 日期
     */
    public static Date stringToDateShort(String dateString) {
        Date dt = stringToDate(dateString, DATE_FORMAT);
        return dt;
    }
    
    /**
     * 取月初
     * 
     * @param date
     * @return
     */
    public static Date getMonthBegin(Date date) {
        String newDateStr = formatDate(date, YEAR_MONTH_FORMAT) + "-01";
        return stringToDateShort(newDateStr);
    }
    
    /**
     * 取月末
     * 
     * @param date
     * @return
     */
    public static final Date getMonthEnd(Date date) {
        if (date == null)
            return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }
    
    
    /**
     * 
     * 根据时间和第几天获取对应时间
     * @param date
     * @param day
     * @return
     */
    public static final Date getOneDay(Date date,int day) {
        if (date == null)
            return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    
    /**
     * 对日期进行格式化
     * 
     * @param date
     *            日期
     * @param sf
     *            日期格式
     * @return 字符串
     */
    public static String formatDate(Date date, String sf) {
        if (date == null)
            return "";
        DateFormat dateformat = new SimpleDateFormat(sf);
        return dateformat.format(date);
    }
    
    public static int getYear(Date d) {
        if (d == null)
            return 0;
        final Calendar c = new GregorianCalendar();
        c.setTime(d);
        return c.get(Calendar.YEAR);
    }
    
    
    /**
     * 
     * 粗略计算差几个月 比如 10.21-11.21 是一个月 1.1-2.28 还是一个月
     * 计算逻辑为： (endYear - beginYear) * 12 + (endMonth - beginMonth);
     * 
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long MonthSubtract(Date beginDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(beginDate);
        int beginYear = calendar.get(Calendar.YEAR);
        int beginMonth = calendar.get(Calendar.MONTH);
        
        calendar.setTime(endDate);
        int endYear = calendar.get(Calendar.YEAR);
        int endMonth = calendar.get(Calendar.MONTH);
        
        int years = endYear - beginYear;
        int months = endMonth - beginMonth;
        
        return 12 * years + months;
    }
    
    
    /**
	 * 
	 * 精确计算两个时间相差几个月，结束月份如果为当月1号的00:00:00 则不参与累计，否则结束月份也参与累计，示例如下：
	 * 
	 * <pre>
	 * 1. 2016-01-01 00:00:00 - 2016-01-02 00:00:00 不足一个月，计为一个月
	 * 2. 2016-01-01 00:00:00 - 2016-01-31 23:59:59 刚好一个月，计为一个月
	 * 3. 2016-01-01 00:00:00 - 2016-02-01 00:00:00 计为一个月（由于零点）
	 * 4. 2016-01-01 00:00:00 - 2016-02-01 00:00:01 超出一个月，计为两个月（即使超出一秒）
	 * 5. 2016-01-31 23:59:59 - 2016-02-01 00:00:01 计为两个月（超出一秒）
	 * 6. 2016-01-31 23:59:59 - 2016-02-01 00:00:00 计为一个月（由于零点）
	 * 7. 2016-01-31 23:59:59 - 2016-02-01 23:59:59 计为两个月
	 * 8. 2016-01-31 23:59:59 - 2016-02-28 23:59:59 计为两个月
	 * 9. 2016-01-20 12:00:00 - 2016-02-18 00:00:00 计为两个月
	 * 10. 2016-01-20 12:00:00 - 2016-01-20 12:00:00 计为一个月
	 * </pre>
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long monthSubtractAccurate(Date beginDate, Date endDate) {
		// 结束日期早于开始日期
		if(endDate.before(beginDate)){
			return -1;
		}
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(beginDate);
		int beginYear = calendar.get(Calendar.YEAR);
		int beginMonth = calendar.get(Calendar.MONTH);
		
		calendar.setTime(endDate);
		int endYear = calendar.get(Calendar.YEAR);
		int endMonth = calendar.get(Calendar.MONTH);
		int endHour = calendar.get(Calendar.HOUR_OF_DAY);
		int endDay = calendar.get(Calendar.DAY_OF_MONTH);
		int endMinite = calendar.get(Calendar.MINUTE);
		int endSecond = calendar.get(Calendar.SECOND);
		
		// 1. 年月相同，肯定在一个月内
		if((beginYear == endYear) && (beginMonth == endMonth)){
			return 1L;
		}else{
			int years = endYear - beginYear;
			int months = endMonth - beginMonth;
			int result = 12 * years + months;

			// 如果不为第一天，则要累计该月，如果为第一天并且时间不为 00:00:00 ，也要累计该月
			if((endDay > 1) || (endHour + endMinite + endSecond > 0)){
				return result + 1;
			}
			return result;
		
		}
	}
}
