package com.apnadukaan.productservice.model.user.representinginheritence.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "msc_ta")
@Entity
@DiscriminatorValue(value =  "1")
public class TA extends User {
    private int numberOfSessions;
    private double avgRating;

}
