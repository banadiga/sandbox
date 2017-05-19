package com.banadiga.springrestdocs.user;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(toBuilder = true)
@Document(collection = "users")
public class User {
  @Id
  private String id;
  private String login;
  private String name;
}
