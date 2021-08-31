package com.example.manpower;

import com.example.manpower.entity.User;
import com.example.manpower.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class JunitTestUser {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateEmployee(){
        User user=new User();
        user.setUserName("Dalila");
        user.setPassword("test");
        user.setEmail("dalila@gmail.com");
        user.setFirstname("Dalila");
        user.setLastname("Ericsson");
        User savedUser= userRepository.save(user);
        User existEmployee=testEntityManager.find(User.class,savedUser.getId() );

    }
}
