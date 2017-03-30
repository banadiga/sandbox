package com.banadiga.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/items", produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class MyController {

  @Autowired
  private MyService myService;

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@Valid MyDto myDto) {
    myService.create(myDto);
  }

  @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public MyDto read(@PathVariable("id") UUID id) {
    return myService.read(id);
  }

  @PutMapping(path = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable("id") UUID id, @Valid MyDto myDto) {
    myService.update(id, myDto);
  }

  @DeleteMapping(path = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") UUID id) {
    myService.delete(id);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public Collection<MyDto> list() {
    return myService.list();
  }
}
