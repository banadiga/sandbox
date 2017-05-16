package com.banadiga.springdatarest.project;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.UUID;

import javax.annotation.PostConstruct;

import static java.util.Arrays.asList;

@Service
@RequiredArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;

  @PostConstruct
  public void init() {
    projectRepository.save(asList(
        Project.builder()
            .name("name " + UUID.randomUUID().toString())
            .build(),
        Project.builder()
            .name("name " + UUID.randomUUID().toString())
            .description("description " + UUID.randomUUID().toString())
            .build()
    ));
  }
}
