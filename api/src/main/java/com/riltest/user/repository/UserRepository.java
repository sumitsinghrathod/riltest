package com.riltest.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.riltest.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
