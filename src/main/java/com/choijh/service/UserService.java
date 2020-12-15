package com.choijh.service;

import java.util.List;
import java.util.Optional;
import com.choijh.model.User;
import com.choijh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User find(int userId) throws Exception{
        Optional<User> searchedUser = this.userRepository.findById(userId);
        return searchedUser.orElseThrow(() -> new Exception("해당 유저를 찾지 못하였습니다"));
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public void initializeUsers() {
        User user1 = User.builder()
                .email("example1@sample.com")
                .name("Mr. Example")
                .phone("01000000000")
                .build();

        User user2 = User.builder()
                .email("example2@sample.com")
                .name("Mrs. Sample")
                .phone("01000001234")
                .build();

        User user3 = User.builder()
                .email("example3@sample.com")
                .name("ms. Sample Data")
                .phone("01012341234")
                .build();

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);
        this.userRepository.flush();
    }
}
