package com.sparta.memo.repository;
import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Repository : JpaRepository를 상속하기 때문에 필요가 없어짐
public interface MemoRepository extends JpaRepository<Memo,Long> { // JpaRepository<Entity,T>

}
