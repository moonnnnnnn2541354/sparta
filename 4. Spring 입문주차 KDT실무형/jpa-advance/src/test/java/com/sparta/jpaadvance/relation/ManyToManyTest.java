package com.sparta.jpaadvance.relation;

import com.sparta.jpaadvance.repository.FoodRepository;
import com.sparta.jpaadvance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class ManyToManyTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FoodRepository foodRepository;


}