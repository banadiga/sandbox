package com.banadiga.springdatarest.employer;


import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@Component
public class EmployerValidator implements Validator {

  @Override
  public boolean supports(Class<?> aClass) {
    return Employer.class.isAssignableFrom(aClass);
  }

  @Override
  public void validate(Object target, Errors errors) {
    final Employer employer = (Employer) target;

    final String firtName = employer.getFirstName();
    if (StringUtils.isEmpty(firtName)) {
      errors.rejectValue("firtName", "400", "First name cannot be empty.");
    }

    final String lastName = employer.getLastName();
    if (StringUtils.isEmpty(lastName)) {
      errors.rejectValue("lastName", "400", "Last name cannot be empty.");
    }

    int yearsOfExperience = employer.getYearsOfExperience();
    if (yearsOfExperience == 0) {
      errors.rejectValue("yearsOfExperience", "400", "They has not enough yearsOfExperience.");
    }
  }
}
