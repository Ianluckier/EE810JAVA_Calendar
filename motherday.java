package motherday;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
public class motherday {
    private static Calendar cal;
    private static DateFormat df;
    private static String sdate;
 
    public static void main(String[] args) throws Exception{
        df = new SimpleDateFormat("M月dd日");
        for (int x=0;x<49;x++){
        	int[] year = new int[50];
            int sundays = 0;
        	year[x]=1980+x;
            cal = Calendar.getInstance();
            cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year[x]);
            cal.set(Calendar.MONTH, 4); // 月份的起始为0
            int maxDate = cal.getActualMaximum(Calendar.DATE);
        for(int i = 1; i <= maxDate; i ++) {
            cal.set(Calendar.DATE, i);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                sundays ++;
                if(sundays == 2) {
                    break;
                }
            }
        }
//        System.out.println(year[x] + "年的母亲节是" + df.format(cal.getTime()));
        sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
        System.out.println(sdate);
        }

    }
 
}