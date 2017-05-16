package com.banadiga.springdatarest.project;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProjectValidator implements Validator {

  @Override
  public boolean supports(Class<?> aClass) {
    return Project.class.isAssignableFrom(aClass);
  }

  @Override
  public void validate(Object target, Errors errors) {
    final Project project = (Project) target;
    final String name = project.getName();
    if (StringUtils.isEmpty(name)) {
      errors.rejectValue("name", "400", "Name cannot be empty.");
    }
  }
}
