package com.bssm.memodev.web.api;

import com.bssm.memodev.service.MemoService;
import com.bssm.memodev.web.dto.CreateMemoRequestDto;
import com.bssm.memodev.web.dto.MemoResponseDto;
import com.bssm.memodev.web.dto.UpdateMemoRequestDto;
import com.bssm.memodev.web.generic.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/memo")
public class MemoApiController {

    private final MemoService memoService;

    @PostMapping("/create")
    public Long createMemo(@RequestBody CreateMemoRequestDto request) {
        return memoService.create(request);
    }

    @GetMapping("/findAll")
    public Result allMemo() {
        return new Result(memoService.all());
    }

    @GetMapping("/find/{id}")
    public MemoResponseDto detailMemo(@PathVariable Long id) {
        return memoService.detail(id);
    }

    @PutMapping("/update/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody UpdateMemoRequestDto request) {

        return memoService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Long delete(@PathVariable Long id) {
        return memoService.delete(id);
    }
}
