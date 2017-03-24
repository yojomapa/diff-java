package com.yojomapa.config;

import com.yojomapa.data.TextRepository;
import com.yojomapa.data.redis.TextRepositoryRedisImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by yojomapa on 23/03/17.
 */
@Profile("test")
@Configuration
public class AppConfig {
  @Bean
  TextRepository textRepository() {
    return Mockito.mock(TextRepositoryRedisImpl.class);
  }
}
