package com.banadiga.junit5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @Autowired
  private MyTopService myTopService;

  @GetMapping(path = "/hi/{name}")
  @ResponseBody
  public MyResponse getMessage(@PathVariable("name") String name) {
    return MyResponse.builder().message(myTopService.getTopMessage(name)).build();
  }
}
