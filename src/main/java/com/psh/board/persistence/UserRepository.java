package com.psh.board.persistence;

import com.psh.board.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByEmail(String username);
    Boolean existsByEmail(String username);
    UserEntity findByEmailAndPassword(String username, String password);
}
