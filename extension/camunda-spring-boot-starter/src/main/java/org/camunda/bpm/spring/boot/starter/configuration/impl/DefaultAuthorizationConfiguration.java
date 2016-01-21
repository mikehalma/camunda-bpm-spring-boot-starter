package org.camunda.bpm.spring.boot.starter.configuration.impl;

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.CamundaBpmProperties.Authorization;
import org.camunda.bpm.spring.boot.starter.configuration.CamundaAuthorizationConfiguration;

public class DefaultAuthorizationConfiguration extends AbstractCamundaConfiguration implements CamundaAuthorizationConfiguration {

  @Override
  public void apply(SpringProcessEngineConfiguration configuration) {
    Authorization authorization = camundaBpmProperties.getAuthorization();
    if (authorization != null) {
      Boolean enabled = authorization.getEnabled();
      if (enabled != null) {
        configuration.setAuthorizationEnabled(enabled);
      }
      Boolean enabledForCustomCode = authorization.getEnabledForCustomCode();
      if (enabledForCustomCode != null) {
        configuration.setAuthorizationEnabledForCustomCode(enabledForCustomCode);
      }
    }
  }

}
