package com.ademozalp.jpaspecifications.helper;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
    SUCCESS(200),
    BAD_REQUEST(400);

    private final Integer code;
}
