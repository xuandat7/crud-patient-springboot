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
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientName;
    private String dateOfBirth;
    private String address;
    private String gender;
    private String medicalHistory;
    private String symptom;
    private String allergy;
    private Boolean isCured;
    private String diagnosis;
    private String prescription;

}

