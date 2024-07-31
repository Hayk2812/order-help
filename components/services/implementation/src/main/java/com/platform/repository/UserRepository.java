package com.platform.repository;

import com.platform.entity.UserEntity;
import com.platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity getByEmail(String email);
    List<UserEntity> getByName(String name);

}
