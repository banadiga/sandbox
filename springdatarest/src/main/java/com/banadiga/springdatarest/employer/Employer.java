package com.banadiga.springdatarest.employer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "employers")
@CompoundIndex(name = "EmployerFullName", def = "{'firstName': 1, 'lastName': 1}", unique = true)
public class Employer {

  @Id
  private String id;

  private String firstName;

  private String lastName;

  private int yearsOfExperience;

  private String photo;
}
