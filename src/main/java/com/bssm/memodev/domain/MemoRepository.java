package com.bssm.memodev.domain;

import com.bssm.memodev.domain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {

}
