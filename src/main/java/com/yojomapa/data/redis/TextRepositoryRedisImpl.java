package com.yojomapa.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of TextRepository tied to RedisDB
 * Created by yojomapa on 22/03/17.
 */
@Repository
public class TextRepositoryRedisImpl implements com.yojomapa.data.TextRepository {

  @Autowired
  private StringRedisTemplate template;

  @Override
  public void add(String key, String value) {
    template.opsForValue().set(key, value);
  }

  @Override
  public String getValue(String key) {
    return template.opsForValue().get(key);
  }

  @Override
  public List<String> getValues(Collection<String> keys) {
    return template.opsForValue().multiGet(keys);
  }

  @Override
  public void delete(String key) {
    template.opsForValue().getOperations().delete(key);
  }

}
