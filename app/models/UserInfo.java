package models;


/**
 * Represents users of the application.
 * @author Rob Namahoe
 */
public class UserInfo {
 
  private String userName;   
  private String firstName; 
  private String lastName;
  private String role;    
  private String telephone;

  /**
   * Creates a new UserInfo instance.
   * @param userName The UH username of the user.
   * @param firstName The users first name.
   * @param lastName The users last name.
   * @param role The users eduPersonAffiliation - student, faculty, etc.
   */
  public UserInfo(String userName, String firstName, String lastName, String role) {
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the role
   */
  public String getRole() {
    return role;
  }

  /**
   * @param role the role to set
   */
  public void setRole(String role) {
    this.role = role;
  }

  /**
   * @return the telephone
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * @param telephone the telephone to set
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * Get the users full name.
   * @return The users first and last name.
   */
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
  
  /**
   * Determines if the current user is faculty.
   * @return true if the current user is a faculty member, false otherwise.
   */
  public boolean isInstructor() {
    return role.equals("faculty");
  }
  
  
}
