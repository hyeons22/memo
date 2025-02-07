package com.example.memopractice1.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto {

    private String name;
    private String content;

    public MemoRequestDto(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
