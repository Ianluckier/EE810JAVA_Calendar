import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileReader;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;  
import org.json.JSONObject;

public class JSON_write_read {  
    /** 
     * @param args 
     * @throws JSONException 
     * @throws IOException 
     */  
	private JSONObject jsonObject;
	private Map<String, String> holidaymap;
	private Map<String, String> Readmap;
	
	public JSON_write_read() {
		jsonObject = new JSONObject();
	}
	public static void writeFile(String filePath, String sets)  
            throws IOException {  
        FileWriter fw = new FileWriter(filePath);  
        PrintWriter out = new PrintWriter(fw);  
        out.write(sets);  
        out.println();  
        fw.close();  
        out.close();  
    }  
  
    public static String ReadFile(String path) {  
        File file = new File(path);  
        BufferedReader reader = null;  
        String laststr = "";  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            while ((tempString = reader.readLine()) != null) {  
                laststr = laststr + tempString;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
        return laststr;  
    }  
    
    public void changeHolidaytoJSON(Map<String, String> holidaymap) throws Exception{
    	this.holidaymap = holidaymap;
    	Set<String> setHolidayDate = holidaymap.keySet();
    	//Set<String> setHolidayName = (Set<String>)holidaymap.values();
    	String[] holidayDate = setHolidayDate.toArray(new String[setHolidayDate.size()]);
    	//String[] holidayName = setHolidayName.toArray(new String[setHolidayName.size()]);
    	for (int i=0; i<holidaymap.size(); i++) {
    		jsonObject.put(holidayDate[i], holidaymap.get(holidayDate[i]));
    	}
    	writeFile("/Users/sumomomubezen/Desktop/666.json", jsonObject.toString());
    }
    
    public Map<String, String> changeJSONtoHoliday(String path) { 
    	Readmap = new HashMap<String, String>();
    	String readHoliday = ReadFile(path);
    	int len_readHoliday = readHoliday.length();
    	String correctFormatHoliday = readHoliday.substring(1, len_readHoliday-1);
    	String[] splitOne = correctFormatHoliday.split(",");
    	for (int i=0; i<splitOne.length; i++) {
    		String[] splitTwo = splitOne[i].split(":");
    		Readmap.put(splitTwo[0], splitTwo[1]);
    	} 
    	System.out.println(Readmap.size());
    	return Readmap;
    }
}