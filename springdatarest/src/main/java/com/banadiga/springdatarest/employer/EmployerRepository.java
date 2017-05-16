package com.banadiga.springdatarest.employer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource(excerptProjection = EmployerListProjection.class)
public interface EmployerRepository extends MongoRepository<Employer, String> {

  @RestResource(path = "withPhoto")
  Collection<Employer> findAllByPhotoIsNotNull();
}
