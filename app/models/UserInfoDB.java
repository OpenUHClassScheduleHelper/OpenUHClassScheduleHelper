package models;

/**
 * An in-memory repo for storing user info.
 * Will be implemented using MySQL at a later time.
 * @author Rob Namahoe
 */
public class UserInfoDB { 
  
  /**
   * Adds the specified user to the UserInfoDB.
   * @param userName The UH userName of the user.
   */
  public static void addUserInfo(String userName) {
    UserInfo user = new UserInfo(userName);
    user.save();
  }
  
  public static void addUserInfo(String userName, String firstName, String lastName) {
    UserInfo user = new UserInfo(userName, firstName, lastName);
    user.save();
  }
  
  /**
   * Returns true if the user name represents a known user.
   * @param userName The users UH user name.
   * @return True if the user exists in the database.
   */
  public static boolean isUser(String userName) {
    return !(UserInfo.find().where().eq("userName", userName).findUnique() == null);
  }
  

  /**
   * Returns the UserInfo associated with the userName, or null if not found.
   * @param userName The users UH user name.
   * @return The UserInfo.
   */
  public static UserInfo getUser(String userName) {
    return UserInfo.find().where().eq("userName", userName).findUnique();
  }

}
