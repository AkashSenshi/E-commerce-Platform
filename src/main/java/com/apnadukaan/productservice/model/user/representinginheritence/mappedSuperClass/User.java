package com.apnadukaan.productservice.model.user.representinginheritence.mappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "msc_users")
@MappedSuperclass
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
