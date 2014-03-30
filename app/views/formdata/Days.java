package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * List of days of the week.
 * @author Evan Komiyama
 *
 */
public class Days {

  private static String[] days = {"M","T","W","Th","F","Sa","Su"};

  /**
   * Initializes list of surfers footstyle.
   * @return typeMap
   */
  public static Map<String, Boolean> getFocusTypes() {
    Map<String, Boolean> dayMap = new HashMap<>();
    for (int i=0; i<days.length;i++) {
        dayMap.put(days[i], false);
    }
    return dayMap;
  }
}