package controllers;

/**
 * Represents a table row extracted by the Jaunt API.
 * @author Rob Namahoe
 */
public class JauntMeetingItem {
    private String crn;
    private String day;
    private String startTime;
    private String endTime;
    private String room;
    
    /**
     * Default Constructor Method.
     */
    public JauntMeetingItem() {
      // Default Constructor Method.
    }
    
    /**
     * Constructor method.
     * @param crn The course crn.
     * @param day The day the course meets.
     * @param startTime The time the class begins.
     * @param endTime The time the class ends. 
     * @param room The room the class is held in.
     */
    public JauntMeetingItem(String crn, String day, String startTime, String endTime, String room) {
      this.crn = crn;
      this.day = day;
      this.startTime = startTime;
      this.endTime = endTime;
      this.room = room;
    }

    /**
     * @return the crn
     */
    public String getCrn() {
      return crn;
    }

    /**
     * @param crn the crn to set
     */
    public void setCrn(String crn) {
      this.crn = crn;
    }

    /**
     * @return the day
     */
    public String getDay() {
      return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
      this.day = day;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
      return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
      this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
      return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
      this.endTime = endTime;
    }

    /**
     * @return the room
     */
    public String getRoom() {
      return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
      this.room = room;
    }

    public void printIt() {
      System.out.println(crn + ", " + day + ", " + startTime + ", " + endTime + ", " + room);
    }
}
