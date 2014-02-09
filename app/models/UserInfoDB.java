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
   * @param name The users name.
   * @param email The users email.
   * @param password The users password. 
   */
  public static void addUserInfo(String name, String email, String password) {
    userinfos.put(email, new UserInfo(name, email, password));
  }
  
  /**
   * Returns true if the email represents a known user.
   * @param email The users email.
   * @return True if the user exists in the database.
   */
  public static boolean isUser(String email) {
    return userinfos.containsKey(email);
  }

  /**
   * Returns the UserInfo associated with the email, or null if not found.
   * @param email The users email.
   * @return The UserInfo.
   */
  public static UserInfo getUser(String email) {
    return userinfos.get((email == null) ? "" : email);
  }

  /**
   * Returns true if email and password are valid credentials.
   * @param email The email. 
   * @param password The password. 
   * @return True if email is a valid user email and password is valid for that email.
   */
  public static boolean isValid(String email, String password) {
    return ((email != null) 
            &&
            (password != null) 
            &&
            isUser(email) 
            &&
            getUser(email).getPassword().equals(password));
  }
}
