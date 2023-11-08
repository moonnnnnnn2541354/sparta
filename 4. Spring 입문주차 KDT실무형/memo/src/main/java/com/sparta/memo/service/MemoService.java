package com.sparta.memo.service;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepository;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    //    public MemoService (ApplicationContext context) {
//        // 1. 'Bean' 이름으로 가져오기
//        MemoRepository memoRepository = (MemoRepository) context.getBean("memoRepository");
//        // 2. 'Bean' 클래스 형식으로 가져오기
//        MemoRepository memoRepository = context.getBean(MemoRepository.class);
//        this.memoRepository = memoRepository;
//    }
    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // DB 저장 : repository 활용
        Memo saveMemo = memoRepository.save(memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {
        // DB 조회
        // DB MemoResponseDto(map) 를 찾아와서 List로 변환
        return memoRepository.findAllByOrderByModifiedAtDesc().stream().map(MemoResponseDto::new).toList();
    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인하고 있으면 예외처리 update, 없으면 예외처리
//        Memo memo = memoRepository.findById(id);
//        if(memo != null) {
//            // memo 내용 수정
//            memoRepository.update(id,requestDto);
//            return id;
//        } else {
//            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
//        }
        // ↑↑ 위 코드를 JPA를 활용하면
        // id확인 코드는 메소드를 따로 만들고 update기능만 구현
        Memo memo = findMemo(id);
        memo.update(requestDto);
        return id;

    }

    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인하고 있으면 delete, 없으면 예외처리
//        Memo memo = memoRepository.findById(id);
//        if(memo != null) {
//            // memo 삭제
//            memoRepository.delete(id);
//            return id;
//        } else {
//            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
//        }
        // ↑↑ 위 코드를 JPA를 활용하면
        // id확인 코드는 메소드를 따로 만들고 delete 기능만 구현
        Memo memo = findMemo(id);
        memoRepository.delete(memo);
        return id;
    }

    private Memo findMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인, 없으면 예외처리
        return memoRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
    }
}
