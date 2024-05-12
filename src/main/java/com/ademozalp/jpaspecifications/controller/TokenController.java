package com.ademozalp.jpaspecifications.controller;

import com.ademozalp.jpaspecifications.dto.TokenResponseDto;
import com.ademozalp.jpaspecifications.helper.DataResult;
import com.ademozalp.jpaspecifications.helper.StatusCode;
import com.ademozalp.jpaspecifications.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.status.StatusConsoleListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tokens")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    @GetMapping
    public DataResult<List<TokenResponseDto>> findTokenByCriteria(Map<String, String> searchCriteria){
        List<TokenResponseDto> data = tokenService.findTokenByCriteria(searchCriteria);

        return DataResult.<List<TokenResponseDto>>builder()
                .data(data)
                .code(StatusCode.SUCCESS.getCode())
                .message("Token retrieved successfully")
                .build();
    }
}
