package com.banadiga.springdatarest.employer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.banadiga.springdatarest.project.Project;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "employers")
@CompoundIndex(name = "EmployerFullName", def = "{'firstName': 1, 'lastName': 1}", unique = true)
@ToString(exclude = {"project"})
public class Employer {

  @Id
  private String id;

  @NotEmpty
  private String firstName;

  @NotEmpty
  private String lastName;

  @Min(1)
  private int yearsOfExperience;

  private String photo;

  @DBRef
  private Project project;
}
