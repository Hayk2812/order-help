package com.platform.springJpa;

import com.platform.entity.UserEntity;
import com.platform.exceptions.UserAlreadyExistException;
import com.platform.exceptions.UserApiException;
import com.platform.exceptions.UserBadRequestException;
import com.platform.exceptions.UserNotFoundExceptions;
import com.platform.model.User;
import com.platform.repository.UserRepository;
import com.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserSpringJpa implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(UUID userId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundExceptions("User not found with given ID");
        }
        return optionalUser.get().toUser();
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = null;

        if (user.getUserId() != null) {
            throw new UserBadRequestException("User ID must be null");
        }
        try {
            userRepository.getByEmail(user.getEmail());
        } catch (Exception e) {
            throw new UserApiException("Problem during creating user");
        }
        if (userEntity != null) {
            throw new UserAlreadyExistException("User already excist with given email");
        }
        try {
            userEntity = userRepository.save(new UserEntity(user));
        } catch (Exception e) {
            throw new UserApiException("Problem during creating user");
        }
        return userEntity.toUser();
    }

    @Override
    public List<User> getUsers() {
        List<UserEntity> userEntities;
        try {
            userEntities = userRepository.findAll();
        } catch (Exception e) {
            throw new UserApiException("Problem during getting users");
        }
       return userEntities
                .stream()
                .map(UserEntity::toUser)
                .toList();

    }

    @Override
    public List<User> getUsersByEmail(String email) {
        try {
            UserEntity userEntity = userRepository.getByEmail(email);
           return List.of(userEntity.toUser());
        }catch (Exception e){
            throw new UserApiException("Problem during getting users");
        }
    }
}
