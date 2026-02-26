package org.example.bstagrambe.user;

import org.example.bstagrambe.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
