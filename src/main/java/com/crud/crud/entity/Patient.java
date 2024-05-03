package com.crud.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "First Name")
    private String firstName;

    @Column(name = "Last Name")
    private String lastName;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Blood Group")
    private String bloodGroup;

    @Column(name = "Medical History")
    private String medicalHistory;

    @Column(name = "Health Insurance Information")
    private String healthInsurance;

    @Column(name = "Allergy")
    private String allergy;

    @Column(name = "Is Cured")
    private Boolean isCured;


}
