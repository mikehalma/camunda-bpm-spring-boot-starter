package org.camunda.bpm.spring.boot.starter.example.webapp.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.spring.boot.starter.example.webapp.service.SayHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mhalma on 01/09/16.
 */
@Component
public class SayHelloEndListener implements ExecutionListener {

  @Autowired
  private SayHelloService sayHelloService;

  @Override
  public void notify(DelegateExecution delegateExecution) throws Exception {
    sayHelloService.sayHello(delegateExecution.toString());
  }
}
