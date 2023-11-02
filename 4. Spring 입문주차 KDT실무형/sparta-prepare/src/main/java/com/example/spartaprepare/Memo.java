package com.example.spartaprepare;

import lombok.*;


@Getter // getter 메소드 생성
@Setter // setter 메소드 생성
@AllArgsConstructor // 생성자 생성
@NoArgsConstructor // 기본 생성자 생성
//@RequiredArgsConstructor // 요구되는 필드대로 만들어지는 생성자 생성

public class Memo {
    private String username;
    private String contents;
}

class Main {
    public static void main(String[] args) {
        Memo memo = new Memo();
        memo.setUsername("Dobby");
        System.out.println(memo.getUsername());
    }
}