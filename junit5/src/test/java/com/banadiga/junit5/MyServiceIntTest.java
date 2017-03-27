package com.banadiga.junit5;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestApplication.class)
public class MyServiceIntTest {

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Autowired
  private MyService myService;

  @Test
  public void getRuntimeException() {
    exception.expect(RuntimeException.class);
    exception.expectMessage("oh?");

    myService.getMessage("oh");
  }

  @Test
  public void getMessageForLongName() {
    String name = "Spring";

    String actual = myService.getMessage(name);

    Assert.assertEquals("Hi Spring", actual);
  }

  @Test
  public void getMessageForShortName() {
    String name = "Li";

    String actual = myService.getMessage(name);

    Assert.assertEquals("Hello Li", actual);
  }
}
