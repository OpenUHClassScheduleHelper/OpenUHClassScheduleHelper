package models;

import java.util.List;

/**
 * A repository to store meeting information.
 * @author Rob Namahoe.
 */
public class MeetingDB {

  /**
   * Add a meeting to the meeting database.
   * @param meeting The meeting to add.
   */
  public static void addMeeting(Meeting meeting) {
    if (!duplicateExists(meeting)) {
      meeting.save();
    }
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
  
  /**
   * Checks for an existing meeting entry in the Meeting table.
   * @param newMeeting The new meeting time.
   * @return true if the meeting already exists, false otherwise.
   */
  private static boolean duplicateExists(Meeting newMeeting) {
    if(newMeeting == null) {
      return false;
    }
    String crn = newMeeting.getCrn();
    List<Meeting> meetings = Meeting.find().where().eq("crn", crn).findList();
    if (meetings.size() > 0) {
      for (Meeting meeting : meetings) {
        if (meeting.getStart().equals(newMeeting.getStart()) && 
            meeting.getEnd().equals(newMeeting.getEnd()) &&
            meeting.getDay().equals(newMeeting.getDay()) &&
            meeting.getRoom().equals(newMeeting.getRoom())) {
            // This meeting already exists in the database, therefore, do not add the duplicate
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean hasConflict(Course course1, Course course2) {
    for(Meeting meeting1 : course1.getMeeting()) {
      for(Meeting meeting2 : course2.getMeeting()) {
        if(meeting1.isOverlapping(meeting2)) {
          return true;
        }
      }
    }
    return false;
  }
  
}
