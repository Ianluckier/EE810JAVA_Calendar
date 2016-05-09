import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
public class SpecificHoliday {
    private static Calendar cal;
    private static DateFormat df;
    private int sundays, maxDate;
    private int currentYear;
    private String sdate_motherday, sdate_fatherday, sdate_laborday, sdate_martinday, sdate_memorialday, sdate_presidentday, sdate_thanksgivingday, sdate_easterday;
    
    public SpecificHoliday() {
    	cal = Calendar.getInstance();
    	sundays = 0;
    }
 
    public String getMotherDayByYear(int year) {    
    	currentYear = year;            
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.MONTH, 4); // 月份的起始为0
        maxDate = cal.getActualMaximum(Calendar.DATE);
        for(int i = 1; i <= maxDate; i++) {
            cal.set(Calendar.DATE, i);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                sundays ++;
                if(sundays == 2) {
                    break;
                }
            }
	    }
        //System.out.println(currentYear + "年的母亲节是" + df.format(cal.getTime()));
        sdate_motherday = (new SimpleDateFormat("M/d")).format(cal.getTime()); 
        //System.out.println(sdate);
        return sdate_motherday;
    }
    
    public String getFatherDayByYear(int year) {    
    	currentYear = year;            
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.MONTH, 5); // 月份的起始为0
        maxDate = cal.getActualMaximum(Calendar.DATE);
        for(int i = 1; i <= maxDate; i++) {
            cal.set(Calendar.DATE, i);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                sundays ++;
                if(sundays == 3) {
                    break;
                }
            }
	    }
        //System.out.println(currentYear + "年的母亲节是" + df.format(cal.getTime()));
        sdate_fatherday = (new SimpleDateFormat("M/d")).format(cal.getTime()); 
        //System.out.println(sdate);
        return sdate_fatherday;
    }
    
    public String getLaborDayByYear(int year) {
    	currentYear = year;            
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.MONTH, 8); // 月份的起始为0
        maxDate = cal.getActualMaximum(Calendar.DATE);
        for(int i = 1; i <= maxDate; i++) {
            cal.set(Calendar.DATE, i);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                sundays ++;
                if(sundays == 1) {
                    break;
                }
            }
	    }
        //System.out.println(currentYear + "年的母亲节是" + df.format(cal.getTime()));
        sdate_laborday = (new SimpleDateFormat("M/d")).format(cal.getTime()); 
    	return sdate_laborday;
    }
    
    public String getMartinDayByYear(int year) {
    	currentYear = year;            
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.MONTH, 0); // 月份的起始为0
        maxDate = cal.getActualMaximum(Calendar.DATE);
        for(int i = 1; i <= maxDate; i++) {
            cal.set(Calendar.DATE, i);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                sundays ++;
                if(sundays == 3) {
                    break;
                }
            }
	    }
        //System.out.println(currentYear + "年的母亲节是" + df.format(cal.getTime()));
        sdate_martinday = (new SimpleDateFormat("M/d")).format(cal.getTime()); 
    	return sdate_martinday;
    }
    
    public String getMemorialDayByYear(int year) {
    	currentYear = year;            
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.MONTH, 5); // 月份的起始为0
        maxDate = cal.getActualMaximum(Calendar.DATE);
        for(int i = 1; i <= maxDate; i++) {
            cal.set(Calendar.DATE, i);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                sundays ++;
                if(sundays == 1) {
                    break;
                }
            }
	    }
        //System.out.println(currentYear + "年的母亲节是" + df.format(cal.getTime()));
        cal.add(Calendar.WEEK_OF_YEAR, -1);
        sdate_memorialday = (new SimpleDateFormat("M/d")).format(cal.getTime()); 
    	return sdate_memorialday;
    }
    
    public String getPresidentDayByYear(int year) {
    	currentYear = year;            
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.MONTH, 1); // 月份的起始为0
        maxDate = cal.getActualMaximum(Calendar.DATE);
        for(int i = 1; i <= maxDate; i++) {
            cal.set(Calendar.DATE, i);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                sundays ++;
                if(sundays == 3) {
                    break;
                }
            }
	    }
        //System.out.println(currentYear + "年的母亲节是" + df.format(cal.getTime()));
        sdate_presidentday = (new SimpleDateFormat("M/d")).format(cal.getTime()); 
    	return sdate_presidentday;
    }
    
    public String getThanksgivingDayByYear(int year) {
    	currentYear = year;            
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.MONTH, 10); // 月份的起始为0
        maxDate = cal.getActualMaximum(Calendar.DATE);
        for(int i = 1; i <= maxDate; i++) {
            cal.set(Calendar.DATE, i);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                sundays ++;
                if(sundays == 4) {
                    break;
                }
            }
	    }
        //System.out.println(currentYear + "年的母亲节是" + df.format(cal.getTime()));
        sdate_thanksgivingday = (new SimpleDateFormat("M/d")).format(cal.getTime()); 
    	return sdate_thanksgivingday;
    }
    
    public String getEasterDayByYear(int year) {
	    int a = year % 19,
	        b = year / 100,
	        c = year % 100,
	        d = b / 4,
	        e = b % 4,
	        g = (8 * b + 13) / 25,
	        h = (19 * a + b - d - g + 15) % 30,
	        j = c / 4,
	        k = c % 4,
	        m = (a + 11 * h) / 319,
	        r = (2 * e + 2 * j - k - h + m + 32) % 7,
	        n = (h - m + r + 90) / 25,
	        p = (h - m + r + n + 19) % 32;

        int resultmonth = 0;
        switch(n)
        {
            case 1:
            	resultmonth = 1;
                break;
            case 2:
            	resultmonth = 2;
                break;
            case 3:
            	resultmonth = 3;
                break;
            case 4:
            	resultmonth = 4;
                break;
            case 5:
            	resultmonth = 5;
                break;
            case 6:
            	resultmonth = 6;
                break;
            case 7:
            	resultmonth = 7;
                break;
            case 8:
            	resultmonth = 8;
                break;
            case 9:
            	resultmonth = 9;
                break;
            case 10:
            	resultmonth = 10;
                break;
            case 11:
            	resultmonth = 11;
                break;
            case 12:
            	resultmonth = 12;
                break;
        }
        sdate_easterday = resultmonth + "/" + p;    	    
    	return sdate_easterday;
    }
}
