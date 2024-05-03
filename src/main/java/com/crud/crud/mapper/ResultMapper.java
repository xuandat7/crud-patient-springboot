package com.crud.crud.mapper;

import com.crud.crud.dto.ResultDTO;
import com.crud.crud.entity.Result;

public class ResultMapper {
    public static ResultDTO mapToResultDto(Result result){
        return new ResultDTO(
                result.getId(),
                result.getPatientName(),
                result.getDateOfBirth(),
                result.getAddress(),
                result.getGender(),
                result.getMedicalHistory(),
                result.getSymptom(),
                result.getAllergy(),
                result.getIsCured(),
                result.getDiagnosis(),
                result.getPrescription()
        );
    }
    public static Result mapToResult(ResultDTO resultDto){
        return new Result(
                resultDto.getId(),
                resultDto.getPatientName(),
                resultDto.getDateOfBirth(),
                resultDto.getAddress(),
                resultDto.getGender(),
                resultDto.getMedicalHistory(),
                resultDto.getSymptom(),
                resultDto.getAllergy(),
                resultDto.getIsCured(),
                resultDto.getDiagnosis(),
                resultDto.getPrescription()
        );
    }

}
