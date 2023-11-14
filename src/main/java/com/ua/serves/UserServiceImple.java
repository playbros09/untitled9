package com.ua.serves;

import com.ua.model.User;
import com.ua.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService{

    private final UserRepository userRepository;
    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long userId, User incomingUser) {
        User user = getById(userId);

        if(incomingUser.getId()!=null) {
            user.setUsername(incomingUser.getUsername());
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(Long userId){
        User user = getById(userId);
        userRepository.delete(user);
    }
}
