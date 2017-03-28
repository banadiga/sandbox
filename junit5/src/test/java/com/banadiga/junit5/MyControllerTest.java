package com.banadiga.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ContextConfiguration(classes = TestApplication.class)
@Tags({
    @Tag("controller"),
    @Tag("mock")
})
public class MyControllerTest {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private MyController controller;

  @Test
  @DisplayName("message")
  public void getMessage() throws Exception {
    given(this.controller.getMessage("name")).willReturn(MyResponse.builder().message("message").build());

    this.mvc.perform(get("/hi/name").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message", is("message")));
  }

  @Test
  @DisplayName("runtime exception")
  public void getMessageWithRuntimeException() throws Exception {
    given(this.controller.getMessage("name")).willThrow(new RuntimeException("message"));

    this.mvc.perform(get("/hi/name").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("message")));
  }

  @Test
  @DisplayName("exception")
  public void getMessageWithException() throws Exception {
    given(this.controller.getMessage("name")).willAnswer(invocation -> {
      throw new Exception("message");
    });

    this.mvc.perform(get("/hi/name").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isInternalServerError())
        .andExpect(jsonPath("$.error", is("message")));
  }
}
