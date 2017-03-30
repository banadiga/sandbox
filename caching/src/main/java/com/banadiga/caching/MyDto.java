package com.banadiga.caching;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import org.hibernate.validator.constraints.NotBlank;

import java.util.UUID;

import javax.validation.constraints.Null;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "code")
public class MyDto {

  @Null
  private UUID id;

  @NonNull
  @NotBlank
  private String name;

  @NonNull
  @NotBlank
  private String code;
}
