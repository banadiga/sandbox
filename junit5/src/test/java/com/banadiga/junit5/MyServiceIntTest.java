package com.banadiga.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestApplication.class)
@Tags({
    @Tag("integration")
})
public class MyServiceIntTest {

  @Autowired
  private MyService myService;

  @Test
  @Disabled("Not implemented yet")
  public void disabled() {

  }

  @Test
  @DisplayName("runtime exception")
  public void getRuntimeException() {
    Throwable actual = Assertions.assertThrows(RuntimeException.class, () -> myService.getMessage("oh"));
    Assertions.assertEquals("oh?", actual.getLocalizedMessage());
  }

  @Test
  @DisplayName("message with long name")
  public void getMessageForLongName() {
    String name = "Spring";

    String actual = myService.getMessage(name);

    Assertions.assertEquals("Hi Spring", actual);
  }

  @Test
  @DisplayName("message with short name")
  public void getMessageForShortName() {
    String name = "Li";

    String actual = myService.getMessage(name);

    Assertions.assertEquals("Hello Li", actual);
  }
}
