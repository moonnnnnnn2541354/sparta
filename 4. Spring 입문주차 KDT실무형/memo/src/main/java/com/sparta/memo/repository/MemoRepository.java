package com.sparta.memo.repository;
import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository : JpaRepository를 상속하기 때문에 필요가 없어짐
public interface MemoRepository extends JpaRepository<Memo,Long> { // JpaRepository<Entity,T>

    List<Memo> findAllByOrderByModifiedAtDesc(); // 날짜 최신순으로 보기
//    List<Memo> findAllByUsername(String username); // username 찾기

    List<Memo> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);
}
