package com.apnadukaan.productservice.model.user.representinginheritence.joinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructor")
public class Instructor extends User {
    private String Specilization;
}
