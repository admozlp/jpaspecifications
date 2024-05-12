package com.ademozalp.jpaspecifications.helper;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataResult<T> {
    private T data;
    private String message;
    private Integer code;
}
