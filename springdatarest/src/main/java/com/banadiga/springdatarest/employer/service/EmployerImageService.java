package com.banadiga.springdatarest.employer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.banadiga.springdatarest.employer.Employer;
import com.banadiga.springdatarest.employer.repository.EmployerRepository;
import com.banadiga.springdatarest.file.FileService;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployerImageService {

  private final FileService fileService;

  private final EmployerRepository employerRepository;

  public String getPhoto(String id) {
    return getPhoto(employerRepository.findOne(id));
  }

  public String getPhoto(Employer employer) {
    return fileService.download(employer.getPhoto());
  }

  public String uploadPhoto(Employer employer) {
    return fileService.upload(employer.getPhoto());
  }

  public void removePhoto(String id) {
    removePhoto(employerRepository.findOne(id));
  }

  public void removePhoto(Employer employer) {
    employerRepository.removePhoto(employer.getId());
    fileService.delete(employer.getPhoto());
  }
}
