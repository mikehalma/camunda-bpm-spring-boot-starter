package org.camunda.bpm.spring.boot.starter.configuration.impl;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.CamundaBpmProperties;
import org.camunda.bpm.spring.boot.starter.CamundaBpmProperties.Authorization;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultAuthorizationConfigurationTest {

  @Mock
  private CamundaBpmProperties camundaBpmProperties;

  @Mock
  private Authorization authorization;

  @Mock
  private SpringProcessEngineConfiguration configuration;

  @InjectMocks
  private DefaultAuthorizationConfiguration defaultAuthorizationConfiguration;

  @Before
  public void before() {
    defaultAuthorizationConfiguration.camundaBpmProperties = camundaBpmProperties;
    when(camundaBpmProperties.getAuthorization()).thenReturn(authorization);
  }

  @Test
  public void defaultValueTest() {
    authorization = new Authorization();
    assertNull(authorization.getEnabled());
    assertNull(authorization.getEnabledForCustomCode());
  }

  @Test
  public void authorizationNotConfiguredTest1() {
    when(camundaBpmProperties.getAuthorization()).thenReturn(null);
    defaultAuthorizationConfiguration.apply(configuration);
    verify(configuration, never()).setAuthorizationEnabled(Mockito.anyBoolean());
    verify(configuration, never()).setAuthorizationEnabledForCustomCode(Mockito.anyBoolean());
  }

  @Test
  public void authorizationNotConfiguredTest2() {
    when(authorization.getEnabled()).thenReturn(null);
    when(authorization.getEnabledForCustomCode()).thenReturn(null);
    defaultAuthorizationConfiguration.apply(configuration);
    verify(configuration, never()).setAuthorizationEnabled(Mockito.anyBoolean());
    verify(configuration, never()).setAuthorizationEnabledForCustomCode(Mockito.anyBoolean());
  }

  @Test
  public void authorizationEnabledTest() {
    when(authorization.getEnabled()).thenReturn(true);
    when(authorization.getEnabledForCustomCode()).thenReturn(null);
    defaultAuthorizationConfiguration.apply(configuration);
    verify(configuration, only()).setAuthorizationEnabled(true);
  }

  @Test
  public void authorizationEnabledForCustomCodeTest() {
    when(authorization.getEnabled()).thenReturn(null);
    when(authorization.getEnabledForCustomCode()).thenReturn(true);
    defaultAuthorizationConfiguration.apply(configuration);
    verify(configuration, only()).setAuthorizationEnabledForCustomCode(true);
  }
}
