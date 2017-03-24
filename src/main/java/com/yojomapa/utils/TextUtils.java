package com.yojomapa.utils;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yojomapa on 23/03/17.
 */
public class TextUtils {

  /**
   * Compare left and right if have the same length Char by Char and returns a list of differences
   * @param left a String
   * @param right a String
   * @return The list of differences or an empty list if left and right have different length
   */
  public static List<String> getDiffOffSets(String left, String right) {

    List<String> diffs = new ArrayList<>();

    if (left.length() != right.length()) {
      return diffs;
    }

    for (int i = 0; i < left.length() ; i++) {
      if (left.charAt(i) != right.charAt(i)) {
        diffs.add(format("Difference in possition %d", i));
      }
    }

    return diffs;
  }
}
