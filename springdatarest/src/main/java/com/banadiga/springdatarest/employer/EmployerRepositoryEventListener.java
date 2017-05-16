package com.banadiga.springdatarest.employer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.banadiga.springdatarest.file.UploadService;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployerRepositoryEventListener extends AbstractRepositoryEventListener<Employer> {

  private final UploadService uploadService;

  @Override
  protected void onBeforeCreate(final Employer employer) {
    String photoBase64 = employer.getPhoto();

    if (!StringUtils.isEmpty(photoBase64)) {
      try {
        String uploadedPhotoName = uploadService.upload(photoBase64);
        employer.setPhoto(uploadedPhotoName);
        log.info("Uploaded photo for employer {} {}", employer.getFirstName(), employer.getFirstName());
      } catch (IOException e) {
        employer.setPhoto(null);
        log.error("Cat not save photo for employer " + employer.getFirstName() + " " + employer.getFirstName(), e);
      }
    }
  }

  @Override
  public void onAfterDelete(final Employer employer) {
    log.info("Deleted employer with id {}", employer.getId());
  }
}
