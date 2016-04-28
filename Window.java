import java.awt.*;
import java.text.*;
import javax.swing.*;
import java.util.Calendar;
/* 
 * Calendar JFrame Interface
 */

public class Window extends JFrame {
	
	private String[] headers = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	//private DateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");
	private Container c = getContentPane();
	private JPanel p_control, p_display, p_current;
	private JLabel lb, lb_yr, lb_mon, lb_current;
	private JTextField tf_yr, tf_mon;
	private JButton btn_show, btn_before, btn_current, btn_after;
	private Calendar cal = Calendar.getInstance();
	private int year, month, dayOfMon, dayOfWeek;
	private JLabel[] display;
	
	public Window() {
		super("Calendar");
		
	    p_control = new JPanel();
	    p_control.setBackground(Color.orange);
	    p_display = new JPanel();
	    p_display.setLayout(new GridLayout(6,7));
	    p_current = new JPanel();
	    p_current.setBackground(Color.orange);
	    
	    c.add(p_control, BorderLayout.NORTH);
	    c.add(p_display, BorderLayout.CENTER);
	    c.add(p_current, BorderLayout.SOUTH);
	    
	    lb_yr = new JLabel("Year:");
	    lb_mon = new JLabel("Month:");
	    lb_current = new JLabel("");
	    display = new JLabel[35];
	    for (int i=0; i<7; i++) {
	    	lb = new JLabel(headers[i]);
	    	p_display.add(lb);
	    }
	    for (int i=0; i<display.length; i++) {
	    	display[i] = new JLabel("");
	    	//display[i].setText("1");
	    	p_display.add(display[i]);
	    }

	    tf_yr = new JTextField(3);
	    tf_mon = new JTextField(3);
	    
	    btn_show = new JButton("Show");
	    btn_before = new JButton("<");
	    btn_current = new JButton("Now");
	    btn_after = new JButton(">");	  
	    
	    p_control.add(lb_yr);
	    p_control.add(tf_yr);
	    p_control.add(lb_mon);
	    p_control.add(tf_mon);
	    p_control.add(btn_show);
	    p_control.add(btn_before);
	    p_control.add(btn_current);
	    p_control.add(btn_after);
	    p_current.add(lb_current);
        
	    init(cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH) + 1));
	    
		setSize(550, 400);
		setLocation(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    setResizable(false); 
	}
	
	public void init(int year, int month) {
	    cal.setFirstDayOfWeek(Calendar.SUNDAY);
	    //year = cal.get(Calendar.YEAR);
	    //month = cal.get(Calendar.MONTH) + 1;
	    dayOfMon = cal.get(Calendar.DAY_OF_MONTH);
	    dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
	    lb_current.setText("The Current Date is : " + year + "/" + month + "/" + dayOfMon + "   Today is : " + headers[dayOfWeek]);
        tf_yr.setText(year + "");
        tf_mon.setText(month + "");
        int startDay = cal.getFirstDayOfWeek();
        switch (startDay) {
        	case 0:
        		display[0].setText("1");
        		break;
        	case 1:
        		display[1].setText("1");
        		break;
        	case 2:
        		display[2].setText("1");
        		break;
        	case 3:
        		display[3].setText("1");
        		break;
        	case 4:
        		display[4].setText("1");
        		break;
        	case 5:
        		display[5].setText("1");
        		break;
        	case 6:
        		display[6].setText("1");
        		break;
        }
	}
	public static void main(String[] args) {
		Window CalendarWindow = new Window();
	}
}
