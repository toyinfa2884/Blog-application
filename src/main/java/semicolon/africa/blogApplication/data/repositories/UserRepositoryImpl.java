package semicolon.africa.blogApplication.data.repositories;

import semicolon.africa.blogApplication.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    List<User> users = new ArrayList<>();
    @Override
    public User save(User user) {
        users.add(user);
        return findByUserId(user.getUserId());
    }

    @Override
    public User findByUserId(String userId) {
        for(User user : users){
            if(user.getUserId().equalsIgnoreCase(userId));
            return user;
        }
        return null;
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public void delete(String userId) {
        User user = findByUserId(userId);
        delete(user);

    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
