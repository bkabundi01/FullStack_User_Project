package com.fullstack.userfullstack_server.database;

import com.fullstack.userfullstack_server.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(Long user_id);
    Optional<Users> findFirstByOrderByUserIdDesc();
    boolean existsByUserId(Long user_id);
    Optional<Users> findByUserDeletedFalse();

}
