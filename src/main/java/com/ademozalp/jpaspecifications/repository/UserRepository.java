package com.ademozalp.jpaspecifications.repository;

import com.ademozalp.jpaspecifications.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
