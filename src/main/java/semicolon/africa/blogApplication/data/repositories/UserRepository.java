package semicolon.africa.blogApplication.data.repositories;

import semicolon.africa.blogApplication.data.models.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findByUserId(String userId);
    void delete(User user);
    void delete(String userId);
    List<User> findAll();
}
