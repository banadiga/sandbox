package com.banadiga.springdatarest.employer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.banadiga.springdatarest.employer.Employer;
import com.banadiga.springdatarest.employer.service.EmployerLinkService;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployerResourceProcessor implements ResourceProcessor<Resource<Employer>> {

  private final EmployerLinkService employerLinkService;

  @Override
  public Resource<Employer> process(final Resource<Employer> resource) {
    Employer employer = resource.getContent();

    employerLinkService.getPhotoLink(employer).ifPresent(resource::add);
    employerLinkService.getRemovePhotoLink(employer).ifPresent(resource::add);
    employerLinkService.getProjectLink(employer).ifPresent(resource::add);

    return resource;
  }
}
