package com.ademozalp.jpaspecifications.repository;

import com.ademozalp.jpaspecifications.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TokenRepository extends JpaRepository<Token, Long>, JpaSpecificationExecutor<Token> {
}
