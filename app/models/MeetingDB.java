package models;

import java.util.List;

/**
 * A repository to store meeting information.
 * @author Rob Namahoe.
 */
public class MeetingDB {

  /**
   * Add a meeting to the meeting database.
   * @param crn The crn of the course to add.
   * @param day The day the course meets.
   * @param start The start time of the course in the following format: hhmm(a/p)
   * @param end The end time of the course in the following format: hhmm(a/p)
   * @param room The location.
   */
  public static void addMeeting(String crn, String day, String start, String end, String room) {
    Meeting meeting = new Meeting(crn, day, start, end, room);
    meeting.save();
  }
  
  /**
   * Delete all meetings with the matching crn from the meeting table.
   * @param crn The crn of the course to delete from the meeting table.
   */
  public static void removeMeetingsByCrn(String crn) {
    List<Meeting> meetings = Meeting.find().where().eq("crn", crn).findList();
    for (Meeting meeting : meetings) {
      meeting.delete();
    }
  }
  
}
