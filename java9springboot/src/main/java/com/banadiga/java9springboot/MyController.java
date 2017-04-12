package com.banadiga.java9springboot;

import com.banadiga.java9module.Utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @RequestMapping(
      path = "/",
      method = RequestMethod.GET)
  @ResponseBody
  public String get() {
    Utils.doSomething("Spring boot application: Hello world!");
    return "test";
  }
}
