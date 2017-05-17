package com.banadiga.springdatarest.project.controller;

import lombok.RequiredArgsConstructor;

import com.banadiga.springdatarest.employer.Employer;
import com.banadiga.springdatarest.employer.service.EmployerImageService;
import com.banadiga.springdatarest.project.Project;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@RepositoryRestController
@ExposesResourceFor(Project.class)
@RequiredArgsConstructor
public class ProjectRepositoryRestController {

  private final EmployerImageService employerImageService;

  @ResponseBody
  @GetMapping(path = "/projects/{id}/employers")
  public ResponseEntity<Collection<Employer>> getEmployers(@PathVariable final String id) {
    return ResponseEntity.ok().build();
  }
}
