package com.banadiga.springdatarest.project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.banadiga.springdatarest.project.Project;
import com.banadiga.springdatarest.project.service.ProjectLinkService;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectResourceProcessor implements ResourceProcessor<Resource<Project>> {

  private final ProjectLinkService projectLinkService;

  @Override
  public Resource<Project> process(final Resource<Project> resource) {
    Project employer = resource.getContent();

    projectLinkService.getEmployersLink(employer).ifPresent(resource::add);

    return resource;
  }
}
