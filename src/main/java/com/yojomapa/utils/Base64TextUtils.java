package com.yojomapa.utils;

import java.util.Base64;

/**
 * Created by yojomapa on 23/03/17.
 */
public class Base64TextUtils {
  public static String transformToString(String base64Text) {
    byte[] bytes = Base64.getDecoder().decode(base64Text);
    return new String(bytes);
  }
}
