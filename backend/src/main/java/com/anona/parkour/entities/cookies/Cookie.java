package com.anona.parkour.entities.cookies;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "cookies")
@Data
public class Cookie {

    @Id
    @GeneratedValue
    public Long id;
    public Long userId;
    public String session;
    private OffsetDateTime lastAccess;

}
