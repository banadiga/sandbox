package com.banadiga.junit5;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyError {
  private String error;
}
