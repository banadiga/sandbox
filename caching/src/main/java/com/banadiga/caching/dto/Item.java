package com.banadiga.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.hibernate.validator.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id", "code"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Item {

  private String id;

  @NotBlank
  private String name;

  @NotBlank
  private String code;
}
