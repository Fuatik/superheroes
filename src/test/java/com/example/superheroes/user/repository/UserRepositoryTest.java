package com.example.superheroes.user.repository;

import com.example.superheroes.user.entity.UserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository underTest;
    String email = "testEmail@gmail.com";

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenUserEmailExists() {
        UserEntity user = new UserEntity(email, "2343525524");

        underTest.save(user);

        boolean expected = underTest.selectExistsEmail(email);

        assertThat(expected).isTrue();
    }

    @Test
    void itShouldFindUserWhenEmailExists() {
        UserEntity user = new UserEntity(email, "2343525524");

        underTest.save(user);

        UserEntity expected = underTest.findByEmail(email);

        assertThat(expected).isEqualTo(user);
    }

    @Test
    void itShouldCheckWhenUserEmailDoesNotExists() {
        String emailFalse = "dennis@gmail.com";


        boolean expected = underTest.selectExistsEmail(emailFalse);


        assertThat(expected).isFalse();
    }
}
