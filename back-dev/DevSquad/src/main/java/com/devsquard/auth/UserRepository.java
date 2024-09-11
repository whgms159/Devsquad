package com.devsquard.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsquard.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
