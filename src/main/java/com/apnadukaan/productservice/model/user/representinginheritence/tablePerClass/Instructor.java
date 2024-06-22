package com.apnadukaan.productservice.model.user.representinginheritence.tablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_instructor")
public class Instructor extends User {
    private String Specilization;
}
