package com.banadiga.springdatarest.project.repository;

import com.banadiga.springdatarest.project.Project;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ProjectRepository extends MongoRepository<Project, String> {

  @RestResource(path = "name-starts-with", rel = "name-starts-with")
  Collection<Project> findAllByNameStartsWith(@Param("name") String name);
}
