package com.banadiga.springdatarest.employer.repository;

import lombok.RequiredArgsConstructor;

import com.banadiga.springdatarest.employer.Employer;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@RequiredArgsConstructor
public class EmployerRepositoryImpl implements CustomEmployerRepository {
  private final MongoTemplate mongoTemplate;

  @Override
  public void removePhoto(String id) {
    final Update skillsUpdate = new Update().set(PHOTO, null);
    final Query query = Query.query(Criteria.where(ID).is(id));
    mongoTemplate.updateFirst(query, skillsUpdate, Employer.class);
  }
}
