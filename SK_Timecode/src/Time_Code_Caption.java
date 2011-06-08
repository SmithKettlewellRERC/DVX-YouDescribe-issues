
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.sql.Time;

// Array<Time_Code_Caption> time_code_caption;


public class Time_Code_Caption {	

	int eventIndex = 0;
	
	ArrayList<TimeCode> events = new ArrayList<TimeCode>();
	
	class TimeCode
	{		
		int 	eventID;
		Time 	startTime;
		int 	startFrame;
		
		Time 	endTime;
		int 	endFrame;
		
		String 	caption;
		String 	uri;
		
		public int getStartFrame() {
			return startFrame;
		}
		public void setStartFrame(int startFrame) {
			this.startFrame = startFrame;
		}
		public int getEndFrame() {
			return endFrame;
		}
		public void setEndFrame(int endFrame) {
			this.endFrame = endFrame;
		}

		public int getEventID() {
			return eventID;
		}
		public void setEventID(int eventID) {
			this.eventID = eventID;
		}
		public Time getStartTime() {
			return startTime;
		}
		public void setStartTime(Time startTime) {
			this.startTime = startTime;
		}
		public Time getEndTime() {
			return endTime;
		}
		public void setEndTime(Time endTime) {
			this.endTime = endTime;
		}
		public String getCaption() {
			return caption;
		}
		public void setCaption(String caption) {
			this.caption = caption;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		
		String toStringTimeCode()
		{
			return  getEventID() + " " + 
					getStartTime() + "." + getStartFrame() + " " + 
					getEndTime() +"." + getEndFrame()+ " " + 
					getCaption();
		}
		
		TimeCode(String eventId , String startTime, String endTime, String caption)
		{
			setEventID(Integer.parseInt(eventId));
			setStartTime(	new Time(	Integer.parseInt(startTime.substring(1, 2)),
										Integer.parseInt(startTime.substring(4, 5)),
										Integer.parseInt(startTime.substring(7, 8))));
			setStartFrame(Integer.parseInt(startTime.substring(9)));
			setEndTime(	new Time(	Integer.parseInt(endTime.substring(1, 2)),
					Integer.parseInt(endTime.substring(4, 5)),
					Integer.parseInt(endTime.substring(7, 8))));
			setEndFrame(Integer.parseInt(endTime.substring(9)));
			setCaption(caption);
			System.out.println(this.toStringTimeCode());
		}
		
	}

	
	void parseLine(String theLine)
	{
//        System.out.println(theLine);

        StringTokenizer st = 
            new StringTokenizer
                (theLine, "\t");
        String eventID=st.nextToken();
//        eventID = eventID.replace("\"", "");
        String startTime=st.nextToken();
        String endTime=st.nextToken();
        String caption=st.nextToken();
        
        TimeCode tc = new TimeCode(eventID, startTime, endTime, caption);
        events.add(tc);
 /*    
     while(st.hasMoreTokens()){
       String s=st.nextToken();
       System.out.print(s);
       System.out.print("\t");
       }	
     System.out.println(); */
	}
	
	void getNextEvent(Time time, Time offset)
	{
		System.out.println(time + " ---" + offset);
		
		time.setTime(time.getTime()-offset.getTime());
		TimeCode nextEvent = events.get(eventIndex);
		Time nextTime = nextEvent.getStartTime();
		
		System.out.println(time + " ->" + nextTime);
		if (time.after(nextTime))
		{
			eventIndex++;
			System.out.println(nextEvent.getEventID() + ":" + nextEvent.getStartTime() + " - " + nextEvent.getCaption());
		}
	}
	void doIt(String filePath)
	{
	       try {
	           FileInputStream fin =  new FileInputStream(filePath);
	           // JDK1.1+
	           String thisLine;
	           BufferedReader myInput = new BufferedReader
	               (new InputStreamReader(fin));
	           while ((thisLine = myInput.readLine()) != null) {  
	              // System.out.println(thisLine);
	              parseLine(thisLine);
	              }
	           }
	        catch (Exception e) {
	          e.printStackTrace();
	          }
			Time offsetTime = new Time(0);
			
			Time nowTime = new Time(0);
			
			while (true)
			{
				getNextEvent(nowTime, offsetTime);
				long waitTime = System.currentTimeMillis()+(1000/30);
				while (waitTime>System.currentTimeMillis())
				{
					// nop until 1/30 of a second
				}
				nowTime.setTime(nowTime.getTime() + (1000/30)) ;
			}
	       	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time_Code_Caption tcc = new Time_Code_Caption();
		tcc.doIt("VIDEO_TS.csv");
	}

}
