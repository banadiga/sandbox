package com.banadiga.springdatarest.employer.controller;

import lombok.RequiredArgsConstructor;

import com.banadiga.springdatarest.employer.Employer;
import com.banadiga.springdatarest.employer.service.EmployerImageService;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@RepositoryRestController
@ExposesResourceFor(Employer.class)
@RequiredArgsConstructor
public class EmployerRepositoryRestController {

  private final EmployerImageService employerImageService;


  @ResponseBody
  @GetMapping(path = "/employers/{id}/image.jpeg")
  public ResponseEntity<byte[]> getPhoto(@PathVariable final String id) {
    byte[] photo = employerImageService.getPhoto(id).getBytes();
    return ResponseEntity.ok().headers(getImageHeaders(photo)).body(photo);
  }

  @ResponseBody
  @GetMapping(path = "/employers/{id}/image")
  public ResponseEntity removePhoto(@PathVariable final String id) {
    employerImageService.removePhoto(id);
    return ResponseEntity.noContent().build();
  }

  private HttpHeaders getImageHeaders(byte[] photo) {
    HttpHeaders headers = new HttpHeaders();
    headers.setLastModified(Calendar.getInstance().getTime().getTime());
    headers.setCacheControl("no-cache");
    headers.setContentType(MediaType.IMAGE_JPEG);
    headers.setContentLength(photo.length);
    return headers;
  }
}
