package com.anona.parkour.entities.data;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Generated
    private Long id;
    private String name;
    private String lastName;
    private String username;
    private String passHash;
    private String email;

}
