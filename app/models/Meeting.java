package models;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
  
  private String day;
  private String start;
  private String end;
  private String room;

  /**
   * default constructor.
   */
  public Meeting() {
    //default constructor
  }
  
  /**
   * Constructor.
   * @param day
   * @param start
   * @param end
   */
  public Meeting(String day, String start, String end, String room) {
	this.setDay(day)
	this.setStart(start)
	this.setEnd(end)    
	this.setRoom(room)
  }
  
  public String getDay() {
    return day;
  }
  
  public void setDay(String day) {
    this.day = day;
  }
  
  public String getStart() {
    return start;
  }
  
  public void setStart(String start) {
    this.start = start;
  }
  
  public String getEnd() {
    return end;
  }
  
  public void setEnd(String end) {
    this.end = end;
  }

  public String getRoom() {
    return room;
  }
  
  public void setRoom(String room) {
    this.room = room;
  }
  
}