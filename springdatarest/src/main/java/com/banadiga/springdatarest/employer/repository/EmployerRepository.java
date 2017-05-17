package com.banadiga.springdatarest.employer.repository;

import com.banadiga.springdatarest.employer.Employer;
import com.banadiga.springdatarest.employer.projection.EmployerListProjection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource(excerptProjection = EmployerListProjection.class)
public interface EmployerRepository extends MongoRepository<Employer, String>, CustomEmployerRepository {

  @RestResource(path = "withPhoto", rel = "with-photo")
  Collection<Employer> findAllByPhotoIsNotNull();

  @RestResource(path = "withoutPhoto", rel = "without-photo")
  Collection<Employer> findAllByPhotoIsNull();
}
