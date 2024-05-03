package com.crud.crud.controller;

import com.crud.crud.dto.PatientDTO;
import com.crud.crud.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO){
        PatientDTO savedPatientDTO = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(savedPatientDTO, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("id") Long patientId){
        PatientDTO patientDTO = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patientDTO);
    }

    @GetMapping
    public ResponseEntity<Object> getAllPatients(){
        List<PatientDTO> patientDTOList = patientService.getAllPatients();
        return ResponseEntity.ok(patientDTOList);
    }

    @PutMapping("{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable("id") Long patientId, @RequestBody PatientDTO updatedPatient){
        PatientDTO patientDTO = patientService.updatePatient(patientId, updatedPatient);
        return ResponseEntity.ok(patientDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Long patientId){
        patientService.deletePatient(patientId);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
