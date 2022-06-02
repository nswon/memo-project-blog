package com.bssm.memodev.service;

import com.bssm.memodev.web.dto.CreateMemoRequestDto;
import com.bssm.memodev.web.dto.MemoResponseDto;
import com.bssm.memodev.web.dto.UpdateMemoRequestDto;

import java.util.List;

public interface MemoService {

    Long create(CreateMemoRequestDto request);
    List<MemoResponseDto> all();
    MemoResponseDto detail(Long id);
    Long update(Long id, UpdateMemoRequestDto request);
    Long delete(Long id);
}
