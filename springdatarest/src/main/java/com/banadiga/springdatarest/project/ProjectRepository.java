package com.banadiga.springdatarest.project;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ProjectRepository extends MongoRepository<Project, String> {

  @RestResource(path = "nameStartsWith")
  Collection<Project> findAllByNameStartsWith(@Param("name") String name);
}
