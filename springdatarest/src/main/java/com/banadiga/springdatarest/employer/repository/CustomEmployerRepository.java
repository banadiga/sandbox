package com.banadiga.springdatarest.employer.repository;

public interface CustomEmployerRepository {
  String PHOTO = "photo";
  String ID = "_id";

  void removePhoto(String id);
}
