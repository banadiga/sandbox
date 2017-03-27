package com.banadiga.junit5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class MyTopServiceTest {

  @Mock
  private MyService myService;

  @InjectMocks
  private MyTopService myTopService;

  @Test
  public void getTopMessage() throws Exception {
    Mockito.doReturn("message").when(myService).getMessage("name");

    String actual = myTopService.getTopMessage("name");

    Assert.assertEquals("message!!!", actual);
  }
}
