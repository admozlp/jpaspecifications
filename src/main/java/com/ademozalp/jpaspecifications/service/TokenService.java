package com.ademozalp.jpaspecifications.service;

import com.ademozalp.jpaspecifications.dto.TokenResponseDto;
import com.ademozalp.jpaspecifications.model.Token;
import com.ademozalp.jpaspecifications.repository.TokenRepository;
import com.ademozalp.jpaspecifications.repository.specs.TokenSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;
    private final JsonDataService jsonDataService;

//    @PostConstruct
//    private void readTokensFromJson(){
//        List<Token> tokens = jsonDataService.readTokensFromJson();
//        tokenRepository.saveAll(tokens);
//    }

    public List<TokenResponseDto> findTokenByCriteria(Map<String, String> searchCriteria, String sortField) {
        Specification<Token> spec = Specification.where(null);

        for(Map.Entry<String, String> entry : searchCriteria.entrySet()){
            if(StringUtils.hasLength(entry.getValue())){
                spec = switch (entry.getKey()) {
                    case "id" -> spec.and(TokenSpecs.hasId(Long.valueOf(entry.getValue())));
                    case "token" -> spec.and(TokenSpecs.byToken(entry.getValue()));
                    case "expired" -> spec.and(TokenSpecs.byExpired(Boolean.valueOf(entry.getValue())));
                    case "revoked" -> spec.and(TokenSpecs.byRevoked(Boolean.valueOf(entry.getValue())));
                    case "ipAdress" -> spec.and(TokenSpecs.containsIpAdress(entry.getValue()));
                    case "username" -> spec.and(TokenSpecs.containsUsername(entry.getValue()));
                    case "createdDateStart" ->
                            spec.and(TokenSpecs.createdDateBetween(LocalDateTime.parse(entry.getValue()),
                                    LocalDateTime.parse(searchCriteria.get("createdDateEnd"))));
                    case "lastModifiedDateStart" ->
                            spec.and(TokenSpecs.lastModifiedDateBetween(LocalDateTime.parse(entry.getValue()),
                                    LocalDateTime.parse(searchCriteria.get("lastModifiedDateEnd")))); default -> spec;
                };
            }
        }
        return tokenRepository.findAll(spec, Sort.by(Sort.Direction.ASC, sortField)).stream().map(TokenResponseDto::convert).toList();
    }
}
