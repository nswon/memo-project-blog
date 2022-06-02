package com.bssm.memodev.web.dto;

import com.bssm.memodev.domain.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class MemoResponseDto {

    private Long id;
    private String title;
    private String content;

    @Builder
    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.content = memo.getContent();
    }
}
