package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {
    private  final Map<Long,Memo> memoList = new HashMap<>();

    // post 생성
    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // Memo Max ID Check
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);

        // DB 저장
        memoList.put(memo.getId(), memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }

    // get 불러오기
    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        // 저장된 메모는 1개가 아니니까 List형식으로 만들어야함

        //Map to List
        List<MemoResponseDto> responseList = // responseList라는 List를 만드는데 값은,
                memoList.values().stream() // memoList를 돌려서 나온
                        .map(MemoResponseDto::new) // memo들을 호출해서 (new 생성자로 지명)
                        .toList(); // List로 변환해줘(new 생성자를 변환)
        return responseList;
    }

    // put 수정
    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        if (memoList.containsKey(id)) { // id값이 있으면 true, 없으면 false;
            // 메모 가져오기
            Memo memo = memoList.get(id);

            // memo 수정
            memo.update(requestDto);
            return memo.getId();
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    // delete 삭제
    @DeleteMapping("/memos/{id}")
    public Long deleteMemo (@PathVariable Long id){
        // 해당 메모가 DB에 존재하는지 확인
        if (memoList.containsKey(id)) {
            // 해당 메모 삭제
            memoList.remove(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }
}
