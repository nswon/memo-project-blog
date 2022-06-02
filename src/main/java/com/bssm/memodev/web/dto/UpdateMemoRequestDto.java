package com.bssm.memodev.web.dto;

import com.bssm.memodev.domain.entity.Memo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateMemoRequestDto {

    private String title;
    private String content;

    @Builder
    public UpdateMemoRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
