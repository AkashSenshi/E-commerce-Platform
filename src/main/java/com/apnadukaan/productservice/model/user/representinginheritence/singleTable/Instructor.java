package com.apnadukaan.productservice.model.user.representinginheritence.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "msc_instructor")
@Entity
@DiscriminatorValue(value =  "3")
public class Instructor extends User {
    private String Specilization;
}
