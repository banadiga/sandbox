package com.banadiga.springdatarest.employer.projection;

import com.banadiga.springdatarest.employer.Employer;

import org.springframework.data.rest.core.config.Projection;

// FIXME Set as default for Employer
@Projection(types = Employer.class, name = "default")
public interface EmployerDefaultProjection {

  String getFirstName();

  String getLastName();

  int getYearsOfExperience();
}
