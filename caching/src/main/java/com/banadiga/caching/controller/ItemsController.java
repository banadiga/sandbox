package com.banadiga.caching.controller;

import com.banadiga.caching.dto.Item;
import com.banadiga.caching.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/items")
public class ItemsController {

  @Autowired
  private ItemService itemService;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public Item create(Item item) {
    return itemService.create(item);
  }

  @GetMapping(path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public Item read(@PathVariable("id") String id) {
    return itemService.read(id);
  }

  @RequestMapping(method = RequestMethod.PUT, path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public Item update(@PathVariable("id") String id, Item item) {
    return itemService.update(id, item);
  }

  @DeleteMapping(path = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") String id) {
    itemService.delete(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public Collection<Item> list() {
    return itemService.list();
  }
}
