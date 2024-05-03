package com.crud.crud.service.impl;

import com.crud.crud.dto.ResultDTO;
import com.crud.crud.entity.Result;
import com.crud.crud.exception.ResourceNotFoundException;
import com.crud.crud.mapper.ResultMapper;
import com.crud.crud.repository.ResultRepository;
import com.crud.crud.service.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResultServiceImpl implements ResultService {
    private ResultRepository resultRepository;

    @Override
    public ResultDTO createResult(ResultDTO resultDTO) {
        Result result = ResultMapper.mapToResult(resultDTO);
        Result savedResult =resultRepository.save(result);
        return ResultMapper.mapToResultDto(savedResult);
    }

    @Override
    public ResultDTO getResultById(Long resultId) {
        Result result = resultRepository.findById(resultId).orElseThrow(() ->
                new ResourceNotFoundException("Result is not exist"));
        return ResultMapper.mapToResultDto(result);
    }

    @Override
    public List<ResultDTO> getAllResults() {
        List<Result> results = resultRepository.findAll();
        return results.stream().map(ResultMapper::mapToResultDto).collect(Collectors.toList());
    }

    @Override
    public ResultDTO updateResult(Long resultId, ResultDTO updatedResult) {
        Result result = resultRepository.findById(resultId).orElseThrow(() ->
                new ResourceNotFoundException("Patient is not exists"));
        result.setPatientName(updatedResult.getPatientName());

        result.setMedicalHistory(updatedResult.getMedicalHistory());
        result.setIsCured(updatedResult.getIsCured());
        result.setDiagnosis(updatedResult.getDiagnosis());
        result.setPrescription(updatedResult.getPrescription());
        result.setAllergy(updatedResult.getAllergy());

        Result updatedResultObj = resultRepository.save(result);
        return ResultMapper.mapToResultDto(updatedResultObj);
    }

    @Override
    public void deleteResult(Long resultId) {
        Result result = resultRepository.findById(resultId).orElseThrow(() ->
                new ResourceNotFoundException("Result is not exists"));
        resultRepository.deleteById(resultId);
    }
}
