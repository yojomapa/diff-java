package com.yojomapa.data;

import java.util.Collection;
import java.util.List;

/**
 * This is an abstraction over what could be done with the Text when interacting with a persistence
 * storage or DB.
 * Created by jorge on 23/03/17.
 */
public interface TextRepository {
  void add(String key, String value);

  String getValue(String key);

  List<String> getValues(Collection<String> keys);

  void delete(String key);
}
