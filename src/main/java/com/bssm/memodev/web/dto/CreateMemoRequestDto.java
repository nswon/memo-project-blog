package com.bssm.memodev.web.dto;

import com.bssm.memodev.domain.entity.Memo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateMemoRequestDto {

    private String title;
    private String content;

    public Memo toEntity() {
        return Memo.builder()
                .title(title)
                .content(content)
                .build();
    }

    @Builder
    public CreateMemoRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
