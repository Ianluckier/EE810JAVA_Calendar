import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

public class ReminderWindow extends JFrame{
	private Container c = getContentPane();
	private JPanel p_holiday, p_event, p_holidayheader, p_eventheader, p_showholiday, p_showevent;
	private JLabel lb_holiday, lb_event;
	private JTextArea ta_holiday, ta_event;
	private int wx, hy, lx, ly;
	private int currentYear, currentMonth, currentDay;
	private Map<String, String> holidaymap;
	private Date currentDate, holidayDate;
	private Calendar cal;
	private String content = "";
	public ReminderWindow() {
		super("Reminder");
		p_holiday = new JPanel();
		p_holiday.setLayout(new BorderLayout());
		p_event = new JPanel();
		p_event.setLayout(new BorderLayout());
		p_holidayheader = new JPanel();
		p_holidayheader.setBackground(Color.orange);
		p_showholiday = new JPanel();
		p_showholiday.setBackground(Color.cyan);
		p_eventheader = new JPanel();
		p_eventheader.setBackground(Color.cyan);
		p_showevent = new JPanel();
		p_showevent.setBackground(Color.orange);
		lb_holiday = new JLabel("Legal National Holidays :   ");
		lb_event = new JLabel("Defined Upcoming Events : ");		
		ta_holiday = new JTextArea("111");
		ta_holiday.setEditable(false);
		ta_holiday.setBackground(Color.cyan);
		ta_event = new JTextArea("未完待续");
		ta_event.setEditable(false);
		ta_event.setBackground(Color.orange);		
		c.add(p_holiday, BorderLayout.WEST);
		c.add(p_event, BorderLayout.CENTER);
		p_holiday.add(p_holidayheader, BorderLayout.NORTH);
		p_holiday.add(p_showholiday, BorderLayout.CENTER);
		p_event.add(p_eventheader, BorderLayout.NORTH);
		p_event.add(p_showevent, BorderLayout.CENTER);
		p_holidayheader.add(lb_holiday);
		p_eventheader.add(lb_event);
		p_showholiday.add(ta_holiday);
		p_showevent.add(ta_event);
		
		wx = MyCalendarWindow.getwidthx();
		lx = MyCalendarWindow.getlocationx();
		hy = MyCalendarWindow.getheighty();
		ly = MyCalendarWindow.getlocationy();
		setSize(wx -150, hy);
		setLocation(wx + lx , ly);	
		setVisible(true);
	    setResizable(false); 
	}
	
	public void setHolidayContent(int currentYear, int currentMonth, int currentDay, Map<String, String> holidaymap) throws ParseException {
		this.currentYear = currentYear;
		this.currentMonth = currentMonth;
		this.currentDay = currentDay;
		this.holidaymap = holidaymap;
		cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd");  
		currentDate = sdf.parse(currentYear + "," + currentMonth + "," + currentDay);	
		for (int i=0; i<holidaymap.size(); i++) {
			Set<String> set = holidaymap.keySet();
		    String[] allholidays = set.toArray(new String[set.size()]); 
			holidayDate= sdf.parse(currentYear + "," + allholidays[i]);
			cal.setTime(currentDate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(holidayDate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000*3600*24);
			if (between_days > 0) {
				content += holidaymap.get(allholidays[i]) + "still" + between_days + "Days" + "\n";
			}
		}
		ta_holiday.setText(content);
	}
	
	public static void main(String[] args) {
		new ReminderWindow();
	}
}
