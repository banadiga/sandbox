package com.banadiga.springdatarest.employer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.banadiga.springdatarest.employer.Employer;
import com.banadiga.springdatarest.employer.controller.EmployerRepositoryRestController;
import com.banadiga.springdatarest.project.Project;
import com.banadiga.springdatarest.project.repository.ProjectRepository;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployerLinkService {
  private static final String IMAGE = "image";
  private static final String REMOVE_IMAGE = "remove-image";
  private static final String PROJECT = "project";

  public Optional<Link> getPhotoLink(Employer employer) {
    if (employer.getPhoto() == null) {
      return Optional.empty();
    }

    ResponseEntity responseEntity = ControllerLinkBuilder
        .methodOn(EmployerRepositoryRestController.class)
        .getPhoto(employer.getId());

    return Optional.of(ControllerLinkBuilder.linkTo(responseEntity).withRel(IMAGE));
  }

  public Optional<Link> getRemovePhotoLink(Employer employer) {
    if (employer.getPhoto() == null) {
      return Optional.empty();
    }

    ResponseEntity responseEntity = ControllerLinkBuilder
        .methodOn(EmployerRepositoryRestController.class)
        .removePhoto(employer.getId());

    return Optional.of(ControllerLinkBuilder.linkTo(responseEntity).withRel(REMOVE_IMAGE));
  }

  public Optional<Link> getProjectLink(Employer employer) {
    if (employer.getProject() == null) {
      return Optional.empty();
    }

    Project responseEntity = ControllerLinkBuilder
        .methodOn(ProjectRepository.class)
        .findOne(employer.getProject().getId());

    return Optional.of(ControllerLinkBuilder.linkTo(responseEntity).withRel(PROJECT));
  }
}
