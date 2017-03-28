package com.banadiga.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@DisplayName("MyServiceIntSimpleTest tests")
@Tags({
    @Tag("simple")
})
public class MyServiceIntSimpleTest {

  private static MyService myService = new MyService();

  @Test
  @Disabled("Not implemented yet")
  public void getThrowable() {

  }

  @Test
  @DisplayName("simple runtime exception")
  public void getRuntimeException() {
    Throwable actual = Assertions.assertThrows(RuntimeException.class, () -> myService.getMessage("oh"));

    Assertions.assertEquals("oh?", actual.getLocalizedMessage());
  }

  @Test
  @DisplayName("simple message with long name")
  public void getMessageForLongName() {
    String name = "Spring";

    String actual = myService.getMessage(name);

    Assertions.assertEquals("Hi Spring", actual);
  }

  @Test
  @DisplayName("simple message with short name")
  public void getMessageForShortName() {
    String name = "Li";

    String actual = myService.getMessage(name);

    Assertions.assertEquals("Hello Li", actual);
  }

  @Nested
  public class ProfileUpdateTests {

    @Test
    @Disabled("Not implemented yet")
    public void getMessage1() {
    }

    @Test
    @Disabled("Not implemented yet")
    public void getMessage2() {
    }
  }

  @Nested
  public class MyNestedTest {

    @Test
    @Disabled("Not implemented yet")
    public void getMessageForTooLongName() {
    }

    @Test
    public void getMessageForLongName() {
      String name = "Spring";

      String actual = myService.getMessage(name);

      Assertions.assertEquals("Hi Spring", actual);
    }

  }
}
