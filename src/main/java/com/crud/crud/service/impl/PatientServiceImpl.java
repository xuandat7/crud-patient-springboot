package com.crud.crud.service.impl;

import com.crud.crud.dto.PatientDTO;
import com.crud.crud.entity.Patient;
import com.crud.crud.exception.ResourceNotFoundException;
import com.crud.crud.mapper.PatientMapper;
import com.crud.crud.repository.PatientRepository;
import com.crud.crud.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = PatientMapper.mapToPatient(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.mapToPatientDTO(savedPatient);
    }

    @Override
    public PatientDTO getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient is not existed with the given Id "
         + patientId));
        return PatientMapper.mapToPatientDTO(patient);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream().map(PatientMapper::mapToPatientDTO).collect(Collectors.toList());
    }

    @Override
    public PatientDTO updatePatient(Long patientId, PatientDTO updatedPatient) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()
                -> new ResourceNotFoundException("Patient is not existed with the ID given: " + patientId));
        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
        patient.setGender(updatedPatient.getGender());
        patient.setBloodGroup(updatedPatient.getBloodGroup());
        patient.setAllergy(updatedPatient.getAllergy());
        patient.setHealthInsurance(updatedPatient.getHealthInsurance());
        patient.setIsCured(updatedPatient.getIsCured());
        patient.setMedicalHistory(updatedPatient.getMedicalHistory());

        Patient updatedPatientObj = patientRepository.save(patient);
        return PatientMapper.mapToPatientDTO(updatedPatientObj);
    }

    @Override
    public void deletePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()
                -> new ResourceNotFoundException("Patient is not existed with the ID given: " + patientId));

        patientRepository.deleteById(patientId);
    }
}
