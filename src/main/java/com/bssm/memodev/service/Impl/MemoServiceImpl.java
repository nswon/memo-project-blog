package com.bssm.memodev.service.Impl;

import com.bssm.memodev.domain.MemoRepository;
import com.bssm.memodev.domain.entity.Memo;
import com.bssm.memodev.service.MemoService;
import com.bssm.memodev.web.dto.CreateMemoRequestDto;
import com.bssm.memodev.web.dto.MemoResponseDto;
import com.bssm.memodev.web.dto.UpdateMemoRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    @Override
    public Long create(CreateMemoRequestDto request) {
        return memoRepository.save(request.toEntity()).getId();
    }

    @Override
    public List<MemoResponseDto> all() {
        return memoRepository.findAll().stream()
                .map(MemoResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public MemoResponseDto detail(Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 메모입니다."));

        return MemoResponseDto.builder()
                .memo(memo)
                .build();
    }

    @Transactional
    @Override
    public Long update(Long id, UpdateMemoRequestDto request) {
        Memo memoId = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메모입니다."));

        memoId.update(request.getTitle(), request.getContent());
        log.info("update memo = " + memoId.getContent());
        return memoId.getId();
    }

    @Transactional
    @Override
    public Long delete(Long id) {
        Memo memoId = memoRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메모입니다."));
        memoRepository.deleteById(id);
        return memoId.getId();
    }
}
