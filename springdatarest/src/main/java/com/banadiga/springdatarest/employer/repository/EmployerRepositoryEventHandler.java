package com.banadiga.springdatarest.employer.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.banadiga.springdatarest.employer.Employer;
import com.banadiga.springdatarest.employer.service.EmployerImageService;

import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
@RepositoryEventHandler
@RequiredArgsConstructor
public class EmployerRepositoryEventHandler {

  private final EmployerImageService employerImageService;

  @HandleBeforeCreate
  @HandleBeforeSave
  public void uploadPhoto(final Employer employer) {
    String photoBase64 = employer.getPhoto();

    if (StringUtils.isEmpty(photoBase64)) {
      log.debug("Employer {} without photo", employer);
      return;
    }

    if (photoBase64.endsWith(".jpg")) {
      log.debug("Employer {} with photo", employer);
      return;
    }

    String fileName = employerImageService.uploadPhoto(employer);
    employer.setPhoto(fileName);
  }

  @HandleAfterDelete
  public void showMessageAfterDelete(final Employer employer) {
    log.info("The {} deleted", employer);
  }
}
