package com.apnadukaan.productservice.model.user.representinginheritence.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "msc_mantor")
@Entity
@DiscriminatorValue(value =  "2")
public class Mentor extends User {
    private double mentorRating;
}
