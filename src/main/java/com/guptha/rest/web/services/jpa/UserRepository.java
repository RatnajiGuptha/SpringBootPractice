package com.guptha.rest.web.services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guptha.rest.web.services.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
