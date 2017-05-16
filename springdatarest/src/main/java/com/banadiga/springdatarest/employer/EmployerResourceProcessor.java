package com.banadiga.springdatarest.employer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployerResourceProcessor implements ResourceProcessor<Resource<Employer>> {
  @Override
  public Resource<Employer> process(final Resource<Employer> employerResource) {
    Employer employer = employerResource.getContent();

    if (employer.getPhoto() != null) {
      employerResource.add(ControllerLinkBuilder.linkTo(
          ControllerLinkBuilder.methodOn(EmployerRepositoryRestController.class)
              .image(employer.getId())).withRel("image"));
    }
    return employerResource;
  }
}
