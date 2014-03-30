package models;

import java.util.HashMap;
import java.util.Map;

/**
 * An in-memory repo for storing user info.
 * Will be implemented using MySQL at a later time.
 * @author Rob Namahoe
 */
public class UserInfoDB { 
  
  private static Map<String, UserInfo> userinfos = new HashMap<String, UserInfo>();
  
  /**
   * Adds the specified user to the UserInfoDB.
   * @param userName The UH userName of the user.
   * @param firstName The users first name.
   * @param lastName The users last name.
   * @param role The users role - student, instructor.
   */
  public static void addUserInfo(String userName, String firstName, String lastName, String role) {
    userinfos.put(userName, new UserInfo(userName, firstName, lastName, role));
  }
  
  /**
   * Returns true if the user name represents a known user.
   * @param userName The users UH user name.
   * @return True if the user exists in the database.
   */
  public static boolean isUser(String userName) {
    return userinfos.containsKey(userName);
  }

  /**
   * Returns the UserInfo associated with the userName, or null if not found.
   * @param userName The users UH user name.
   * @return The UserInfo.
   */
  public static UserInfo getUser(String userName) {
    return userinfos.get((userName == null) ? "" : userName);
  }

}
