package com.banadiga.springdatarest.project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.banadiga.springdatarest.project.Project;
import com.banadiga.springdatarest.project.controller.ProjectRepositoryRestController;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectLinkService {
  private static final String EMPLOYERS = "employers";

  public Optional<Link> getEmployersLink(Project project) {
    ResponseEntity responseEntity = ControllerLinkBuilder
        .methodOn(ProjectRepositoryRestController.class)
        .getEmployers(project.getId());

    return Optional.of(ControllerLinkBuilder.linkTo(responseEntity).withRel(EMPLOYERS));
  }
}
