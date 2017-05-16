package com.banadiga.springdatarest.employer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Employer.class, name = "list")
public interface EmployerListProjection {

  @Value("#{target.firstName} #{target.lastName}")
  String getFullName();
}
