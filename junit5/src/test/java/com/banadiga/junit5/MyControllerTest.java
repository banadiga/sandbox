package com.banadiga.junit5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ContextConfiguration(classes = TestApplication.class)
public class MyControllerTest {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private MyController controller;

  @Test
  public void getMessage() throws Exception {
    given(this.controller.getMessage("name")).willReturn(MyResponse.builder().message("message").build());

    this.mvc.perform(get("/hi/name").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message", is("message")));
  }

  @Test
  public void getMessageWithRuntimeException() throws Exception {
    given(this.controller.getMessage("name")).willThrow(new RuntimeException("message"));

    this.mvc.perform(get("/hi/name").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("message")));
  }

  @Test
  public void getMessageWithException() throws Exception {
    given(this.controller.getMessage("name")).willAnswer(invocation -> {
      throw new Exception("message");
    });

    this.mvc.perform(get("/hi/name").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isInternalServerError())
        .andExpect(jsonPath("$.error", is("message")));
  }
}
