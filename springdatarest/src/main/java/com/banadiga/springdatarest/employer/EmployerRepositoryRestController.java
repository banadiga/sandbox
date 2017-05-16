package com.banadiga.springdatarest.employer;

import lombok.RequiredArgsConstructor;

import com.banadiga.springdatarest.file.UploadService;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@RepositoryRestController
@ExposesResourceFor(Employer.class)
@RequiredArgsConstructor
public class EmployerRepositoryRestController {

  private final UploadService uploadService;

  private final EmployerRepository employerRepository;

  @ResponseBody
  @GetMapping(path = "/employers/{id}/image.jpg")
  public ResponseEntity image(@PathVariable final String id) {
    Employer employer = employerRepository.findOne(id);

    if (employer.getPhoto() != null) {
      try {
        return ResponseEntity.ok(uploadService.download(employer.getPhoto()));
      } catch (IOException e) {
        ResponseEntity.unprocessableEntity().build();
      }
    }
    return ResponseEntity.notFound().build();
  }
}
