package com.anona.parkour.repositories.data;

import com.anona.parkour.entities.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
