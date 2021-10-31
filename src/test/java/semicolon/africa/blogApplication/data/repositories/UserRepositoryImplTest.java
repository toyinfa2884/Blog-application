package semicolon.africa.blogApplication.data.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import semicolon.africa.blogApplication.data.models.User;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Add new user to the user repository")
    void save() {
        User user = new User();
        user.setUserId("qwerty");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@gmail.com");
        user.setPassword("~34ggT$^");
        User saveUser = userRepository.save(user);
        assertEquals(user, saveUser);
    }
    @Test
    void findByUserId(){
        User user = new User();
        user.setUserId("qwerty");
        user.setFirstName("Agba");
        user.setLastName("Lagba");
        user.setEmail("agbalagba@gmail.com");
        user.setPassword("@#!e4D");
        User saveUser = userRepository.save(user);
        User userFound = userRepository.findByUserId("565656");
        assertEquals(user, userFound);
    }

    @Test
    void delete() {
        User user = new User();
        user.setUserId("qwerty");
        user.setFirstName("Agba");
        user.setLastName("Lagba");
        user.setEmail("agbalagba@gmail.com");
        user.setPassword("@#!e4D");
        User saveUser = userRepository.save(user);
        assertNotNull(userRepository.findByUserId("asdf"));
        //when
        userRepository.delete(user);
        assertNull(userRepository.findByUserId("asdf"));
    }

    @Test
    void testDelete() {
        User user = new User();
        user.setUserId("qwerty");
        user.setFirstName("Agba");
        user.setLastName("Lagba");
        user.setEmail("agbalagba@gmail.com");
        user.setPassword("@#!e4D");
        userRepository.save(user);
        assertNotNull(userRepository.findByUserId("asdf"));
        //when
        userRepository.delete("asdf");
        assertNull(userRepository.findByUserId("asdf"));
    }

    @Test
    void findAll(){
        User user = new User();
        user.setUserId("qwerty");
        user.setFirstName("Agba");
        user.setLastName("Lagba");
        user.setEmail("agbalagba@gmail.com");
        user.setPassword("@#!e4D");

        userRepository.save(user);
        userRepository.save(user);
        userRepository.save(user);
        userRepository.save(user);
        userRepository.save(user);
        assertEquals(5, userRepository.findAll().size());

    }
}