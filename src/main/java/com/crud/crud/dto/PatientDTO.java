package com.crud.crud.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String gender;

    private String bloodGroup;

    private String medicalHistory;

    private String healthInsurance;

    private String allergy;

    private Boolean isCured;


}
