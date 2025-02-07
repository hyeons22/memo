package com.example.memopractice1.service;

import com.example.memopractice1.dto.MemoRequestDto;
import com.example.memopractice1.dto.MemoResponseDto;
import com.example.memopractice1.entity.Memo;
import com.example.memopractice1.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponseDto save(MemoRequestDto dto) {
        Memo memo = new Memo(dto.getName(), dto.getContent());
        Memo savedMemo = memoRepository.save(memo);
        return new MemoResponseDto(savedMemo.getId(),savedMemo.getName(),savedMemo.getContent());
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> findAll() {
        List<Memo> memos = memoRepository.findAll();
        List<MemoResponseDto> dtoList = new ArrayList<>();

        for (Memo memo : memos) {
            MemoResponseDto dto = new MemoResponseDto(memo.getId(), memo.getName(), memo.getContent());
            dtoList.add(dto);
        }
         return dtoList;
    }

    @Transactional(readOnly = true)
    public MemoResponseDto findById(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 메모가 없어요")
        );

        return new MemoResponseDto(memo.getId(),memo.getName(),memo.getContent());
    }

    @Transactional
    public MemoResponseDto update(Long memoId, MemoRequestDto dto) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 메모가 없어요")
        );

        memo.update(dto.getName(), dto.getContent());
        return new MemoResponseDto(memo.getId(),memo.getName(),memo.getContent());
    }

    @Transactional
    public void deleteById(Long memoId) {
        memoRepository.deleteById(memoId);
    }
}
