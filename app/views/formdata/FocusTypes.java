package views.formdata;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * List of Legal surfer types.
 * @author Taylor Kennedy
 *
 */
public class FocusTypes {

  private static String[] focusTypes = {"ETH","HAP","WI","OC"};

  /**
   * Initializes list of surfers footstyle.
   * @return typeMap
   */
  public static Map<String, Boolean> getFocusTypes() {
    Map<String, Boolean> focusMap = new LinkedHashMap<>();
    for (int i=0; i<focusTypes.length;i++) {
        focusMap.put(focusTypes[i], false);
    }
    return focusMap;
  }
}