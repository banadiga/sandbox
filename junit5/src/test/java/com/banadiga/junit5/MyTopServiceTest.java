package com.banadiga.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestApplication.class)
@Tags({
    @Tag("mock")
})
public class MyTopServiceTest {

  @Mock
  private MyService myService;

  @InjectMocks
  private MyTopService myTopService;

  @Test
  @DisplayName("top message")
  public void getTopMessage() throws Exception {
    Mockito.doReturn("message").when(myService).getMessage("name");

    String actual = myTopService.getTopMessage("name");

    Assertions.assertEquals("message!!!", actual);
  }
}
