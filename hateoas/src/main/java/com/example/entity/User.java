package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Data
@NoArgsConstructor
@XmlRootElement
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  @Column(unique = true)
  private String login;

  private String firstName;
  private String secondName;
}
