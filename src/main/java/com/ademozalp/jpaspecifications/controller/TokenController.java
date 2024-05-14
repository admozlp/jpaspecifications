package com.ademozalp.jpaspecifications.controller;

import com.ademozalp.jpaspecifications.dto.TokenResponseDto;
import com.ademozalp.jpaspecifications.helper.DataResult;
import com.ademozalp.jpaspecifications.helper.StatusCode;
import com.ademozalp.jpaspecifications.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tokens")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    @GetMapping
    public DataResult<List<TokenResponseDto>> findTokenByCriteria(@RequestBody Map<String, String> searchCriteria, @RequestHeader String sortField) {
        List<TokenResponseDto> data = tokenService.findTokenByCriteria(searchCriteria, sortField);

        return DataResult.<List<TokenResponseDto>>builder()
                .data(data)
                .code(StatusCode.SUCCESS.getCode())
                .message("Token retrieved successfully")
                .build();
    }
}
