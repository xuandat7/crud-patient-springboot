package com.crud.crud.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ResultDTO {

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

