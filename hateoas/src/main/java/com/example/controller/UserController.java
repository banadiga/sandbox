package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping(
      path = "/users/{id}/export",
      method = RequestMethod.GET,
      produces = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE, APPLICATION_PDF_VALUE})
  @ResponseBody
  public User findOne(@PathVariable("id") Long id) {
    return userRepository.findOne(id);
  }
}
