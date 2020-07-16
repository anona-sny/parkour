package com.anona.parkour.repositories.cookies;

import com.anona.parkour.entities.cookies.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookieRepository extends JpaRepository<Cookie, Long> {
}
