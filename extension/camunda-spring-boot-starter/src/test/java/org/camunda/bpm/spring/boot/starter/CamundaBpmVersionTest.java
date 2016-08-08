package org.camunda.bpm.spring.boot.starter;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CamundaBpmVersionTest {

  @Test
  public void versionTest() {
    String version = CamundaBpmVersion.getVersion();
    assertTrue("expected sth. like 7.4.xx", StringUtils.isNotBlank(version));
  }

}
