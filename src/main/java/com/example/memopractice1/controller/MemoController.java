package com.example.memopractice1.controller;

import com.example.memopractice1.dto.MemoRequestDto;
import com.example.memopractice1.dto.MemoResponseDto;
import com.example.memopractice1.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<MemoResponseDto> save(@RequestBody MemoRequestDto dto){
        return ResponseEntity.ok(memoService.save(dto));
    }

    @GetMapping("/memos")
    public ResponseEntity<List<MemoResponseDto>> findAll(){
        return ResponseEntity.ok(memoService.findAll());
    }

    @GetMapping("/memos/{memoId}")
    public ResponseEntity<MemoResponseDto> findById(@PathVariable Long memoId){
        return ResponseEntity.ok(memoService.findById(memoId));
    }

    @PutMapping("/memos/{memoId}")
    public ResponseEntity<MemoResponseDto> update(
            @PathVariable Long memoId,
            @RequestBody MemoRequestDto dto
    ){
        return ResponseEntity.ok(memoService.update(memoId, dto));
    }

    @DeleteMapping("/memos/{memoId}")
    public void deleteById(@PathVariable Long memoId){
        memoService.deleteById(memoId);
    }

}
