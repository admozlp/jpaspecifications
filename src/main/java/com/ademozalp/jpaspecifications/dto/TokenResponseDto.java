package com.ademozalp.jpaspecifications.dto;

import com.ademozalp.jpaspecifications.model.Token;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponseDto {
    private Long id;

    private String token;

    private Boolean revoked;

    private Boolean expired;

    private String ipAdress;

    private Long userId;

    private String username;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    public static TokenResponseDto convert(Token from){
        return TokenResponseDto.builder()
                .id(from.getId())
                .token(from.getToken())
                .revoked(from.getRevoked())
                .expired(from.getExpired())
                .ipAdress(from.getIpAdress())
                .userId(from.getUser().getId())
                .username(from.getUser().getUsername())
                .createdDate(from.getCreatedDate())
                .lastModifiedDate(from.getLastModifiedDate())
                .build();
    }
}
