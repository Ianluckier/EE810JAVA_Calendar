import java.util.*;

public class Holidays {
	//private static final String JAN1 = "New Year's Day";
	//private static final String JAN15 = "Martin Luther King Jr.'s Birthday";
	//private static final String JAN21 = "Washington's Birthday";
	//private static final String FEB12 = "Lincoln's Birthday";
	//private static final String FEB14 = "Valentine's Day";
	//private static final String FEB16 = "President's Day";
	//private static final String MAR8 = "International Women's Day";
	//private static final String MAR17 = "St.Patrick's Day";
	//private static final String APR1 = "April Fool's Day";
	//private static final String APR12 = "Easter";
	//private static final String MAY1 = "MAY Day";
	//private static final String MAY6 = "Nurses' Day";
	//private static final String MAY10 = "Mother's Day";
	//private static final String MAY30 = "Memorial Day";
	//private static final String MAR21 = "Father's Day";
	//private static final String JUL4 = "Independence Day";
	//private static final String SEP7 = "Labor Day";
	//private static final String OCT12 = "Columbus Day";
	//private static final String NOV1 = "Halloween";
	//private static final String NOV11 = "Veterans Day";
	//private static final String NOV26 = "Thanksgiving";
	//private static final String DEC25 = "Christmas";
    public static Map<String, String> getHolidays() {
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("1,1", "New Year's Day");
    	map.put("1,15", "Martin Luther King Jr.'s Birthday");
    	map.put("1,21", "Washington's Birthday");
    	map.put("2,12", "Lincoln's Birthday");
    	map.put("2,14", "Valentine's Day");
    	map.put("2,16", "President's Day");
    	map.put("3,8", "International Women's Day");
    	map.put("3,17", "St.Patrick's Day");
    	map.put("4,1", "April Fool's Day");
    	map.put("4,12", "Easter");
    	map.put("5,1", "MAY Day");
    	map.put("5,6", "Nurses' Day");
    	map.put("5,10", "Mother's Day");
    	map.put("5,30", "Memorial Day");
    	map.put("6,19", "Father's Day");
    	map.put("7,4", "Independence Day");
    	map.put("9,7", "Labor Day");
    	map.put("10,12", "Columbus Day");
    	map.put("11,1", "Halloween");
    	map.put("11,11", "Veterans Day");
    	map.put("11,26", "Thanksgiving");
    	map.put("12,25", "Christmas");
    	
    	return map;
    }
}
