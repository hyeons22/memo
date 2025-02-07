package com.example.memopractice1.dto;

import lombok.Getter;

@Getter
public class MemoResponseDto {

    private final Long id;
    private final String name;
    private final String content;

    public MemoResponseDto(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }
}
