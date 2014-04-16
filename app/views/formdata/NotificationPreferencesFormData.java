package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.UserInfo;
import play.data.validation.ValidationError;

/**
 * A class that stores data for the notification preferences form.
 * @author Rob Namahoe
 */
public class NotificationPreferencesFormData {

  /* The users preference - opt-in or opt-out */
  public String userPreference;
  /* The users email address */
  public String userEmail;
  /* The users mobile phone number */
  public String userPhone;
  /* The users mobile phone service provider */
  public String userCarrier;
  
  /**
   * Default Constructor method.
   */
  public NotificationPreferencesFormData() {
    // Default constructor.
  }
  
  /**
   * Constructor method.
   * @param preference The users preference - opt-in or opt-out.
   * @param email The users email address.
   * @param phone The users mobile phone number.
   * @param carrier The users mobile phone service provider.
   */
  public NotificationPreferencesFormData(String preference, String email, String phone, String carrier) {
    this.userPreference = preference;
    this.userEmail = email;
    this.userPhone = phone;
    this.userCarrier = carrier;
  }
  
  /**
   * Constructor method.
   * @param user The current user.
   */
  public NotificationPreferencesFormData(UserInfo user) {
    this.userPreference = user.getNotificationPreference();
    this.userEmail = user.getEmail();
    this.userPhone = user.getTelephone();
    this.userCarrier = user.getCarrier();
  }

  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationErrors if problems are found.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (userPreference.equals("Opt-in")) {
      // If both email and phone number are blank, issue an error.
      if (userEmail.length() == 0 && userPhone.length() == 0) {
        errors.add(new ValidationError("userEmail", "Email or phone number is required."));
        errors.add(new ValidationError("userPhone", "Email or phone number is required."));
      }

      // Validate phone number format.
      if (userPhone.length() > 0) {
        if (!(userPhone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}") || userPhone.matches("\\d{10}"))) {
          errors.add(new ValidationError("userPhone", "Invalid phone number format. Use ###-###-####"));
        }
        if (userCarrier == null || userCarrier.length() == 0) {
          errors.add(new ValidationError("userCarrier", "Service provider cannot be left blank."));
        }
      }
    }
    return errors.isEmpty() ? null : errors; 
  }
}
