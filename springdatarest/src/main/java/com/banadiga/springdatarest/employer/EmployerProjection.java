package com.banadiga.springdatarest.employer;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Employer.class, name = "default")
public interface EmployerProjection {

  String getFirstName();

  String getLastName();

  int getExperience();
}
