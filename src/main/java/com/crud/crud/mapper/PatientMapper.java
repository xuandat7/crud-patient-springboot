package com.crud.crud.mapper;

import com.crud.crud.dto.PatientDTO;
import com.crud.crud.entity.Patient;



public class PatientMapper {
    public static PatientDTO mapToPatientDTO(Patient patient){

        return new PatientDTO(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getGender(),
                patient.getBloodGroup(),
                patient.getMedicalHistory(),
                patient.getHealthInsurance(),
                patient.getAllergy(),
                patient.getIsCured()

        );
    }

    public static Patient mapToPatient(PatientDTO patientDTO){

        return new Patient(
                patientDTO.getId(),
                patientDTO.getFirstName(),
                patientDTO.getLastName(),
                patientDTO.getGender(),
                patientDTO.getBloodGroup(),
                patientDTO.getMedicalHistory(),
                patientDTO.getHealthInsurance(),
                patientDTO.getAllergy(),
                patientDTO.getIsCured()

        );
    }
}
