package com.banadiga.springdatarest;

import lombok.RequiredArgsConstructor;

import com.banadiga.springdatarest.employer.EmployerValidator;
import com.banadiga.springdatarest.project.ProjectValidator;

import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {

  private final ProjectValidator projectValidator;

  private final EmployerValidator employerValidator;

  @Override
  public void configureValidatingRepositoryEventListener(final ValidatingRepositoryEventListener validatingListener) {
    validatingListener.addValidator("beforeCreate", projectValidator);
    validatingListener.addValidator("beforeSave", projectValidator);

    validatingListener.addValidator("beforeCreate", employerValidator);
    validatingListener.addValidator("beforeSave", employerValidator);
  }
}
