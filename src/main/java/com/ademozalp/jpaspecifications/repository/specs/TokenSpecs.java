package com.ademozalp.jpaspecifications.repository.specs;

import com.ademozalp.jpaspecifications.model.Token;
import com.ademozalp.jpaspecifications.model.Token_;
import com.ademozalp.jpaspecifications.model.User_;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class TokenSpecs {

    public static Specification<Token> hasId(Long id){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Token_.ID), id);
    }

    public static Specification<Token> byToken(String token){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Token_.TOKEN), token);
    }

    public static Specification<Token> byExpired(Boolean expired){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Token_.EXPIRED), expired);
    }

    public static Specification<Token> byRevoked(Boolean revoked){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Token_.REVOKED), revoked);
    }

    public static Specification<Token> containsIpAdress(String ipAdress){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Token_.IP_ADRESS),
                "%" + ipAdress + "%");
    }

    public static Specification<Token> containsUsername(String username){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(Token_.USER).get(User_.USERNAME)),
                        "%" + username.toLowerCase() + "%");
    }

    public static Specification<Token> createdDateBetween(LocalDateTime start, LocalDateTime end){
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Token_.CREATED_DATE), start, end);
    }

    public static Specification<Token> lastModifiedDateBetween(LocalDateTime start, LocalDateTime end){
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Token_.CREATED_DATE), start, end);
    }
}
