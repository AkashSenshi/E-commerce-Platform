package com.apnadukaan.productservice.model.user.representinginheritence.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value =  "0")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
