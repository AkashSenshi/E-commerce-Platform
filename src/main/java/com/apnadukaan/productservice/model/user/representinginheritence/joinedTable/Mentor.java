package com.apnadukaan.productservice.model.user.representinginheritence.joinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
public class Mentor extends User {
    private double mentorRating;
}
