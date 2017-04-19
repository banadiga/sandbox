package com.banadiga.fi;

import java.util.Collection;

import static java.util.Arrays.asList;

public class FIApplication {
  private static final Collection<String> MY_LIST
      = asList("a", "ab", "abc", "abcd", "a12345", "b123456789", "c1234567890");

  public static void main(String[] args) {
    Checker checker = name -> name.length() > 3;

    MY_LIST.stream()
        .filter(checker::check)
        .forEach(System.out::println);
  }
}
