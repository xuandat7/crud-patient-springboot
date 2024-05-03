package com.crud.crud.service;


import com.crud.crud.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);
    PatientDTO getPatientById(Long patientId);
    List<PatientDTO> getAllPatients();
    PatientDTO updatePatient(Long patientId, PatientDTO updatedPatient);
    void deletePatient(Long patientId);

}
