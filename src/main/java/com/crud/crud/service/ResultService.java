package com.crud.crud.service;


import com.crud.crud.dto.ResultDTO;


import java.util.List;

public interface ResultService {
    ResultDTO createResult(ResultDTO resultDTO);
    ResultDTO getResultById(Long resultId);
    List<ResultDTO> getAllResults();
    ResultDTO updateResult(Long resultId, ResultDTO updatedResult);
    void deleteResult(Long resultId);
}
