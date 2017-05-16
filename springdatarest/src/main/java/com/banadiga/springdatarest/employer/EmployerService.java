package com.banadiga.springdatarest.employer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.UUID;

import javax.annotation.PostConstruct;

import static java.util.Arrays.asList;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployerService {

  private final EmployerRepository employerRepository;

  @PostConstruct
  public void init() {
    employerRepository.save(asList(
        Employer.builder()
            .firstName("firstName " + UUID.randomUUID().toString())
            .lastName("lastName " + UUID.randomUUID().toString())
            .build(),
        Employer.builder()
            .firstName("firstName " + UUID.randomUUID().toString())
            .lastName("lastName " + UUID.randomUUID().toString())
            .yearsOfExperience(3)
            .build()
    ));
  }
}
