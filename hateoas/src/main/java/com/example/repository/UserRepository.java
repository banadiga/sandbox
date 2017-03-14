package com.example.repository;

import com.example.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
}
