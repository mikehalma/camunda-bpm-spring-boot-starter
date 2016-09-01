package org.camunda.bpm.spring.boot.starter.example.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by mhalma on 01/09/16.
 */
@Component
public class SayHelloService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SayHelloService.class);

  public void sayHello(String message) {
    LOGGER.info("hello service:"  + message);

  }
}
