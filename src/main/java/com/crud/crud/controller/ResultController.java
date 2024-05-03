package com.crud.crud.controller;

import com.crud.crud.dto.PatientDTO;
import com.crud.crud.dto.ResultDTO;
import com.crud.crud.entity.Result;
import com.crud.crud.service.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/results")
public class ResultController {
    private ResultService resultService;

    @PostMapping
    public ResponseEntity<ResultDTO> createResult(@RequestBody ResultDTO resultDTO){
        ResultDTO savedResultDTO = resultService.createResult(resultDTO);
        return new ResponseEntity<>(savedResultDTO, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ResultDTO> getResultById(@PathVariable("id") Long resultId){
        ResultDTO resultDTO = resultService.getResultById(resultId);
        return ResponseEntity.ok(resultDTO);
    }

    @GetMapping
    public ResponseEntity<Object> getAllResult(){
        List<ResultDTO> resultDTOList = resultService.getAllResults();
        return ResponseEntity.ok(resultDTOList);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResultDTO> updateResult(@PathVariable("id") Long resultId, @RequestBody ResultDTO updatedResultDTO){
        ResultDTO resultDTO = resultService.updateResult(resultId, updatedResultDTO);
        return ResponseEntity.ok(resultDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteResult(@PathVariable("id") Long resultId){
        resultService.deleteResult(resultId);
        return ResponseEntity.ok("Result deleted successfully");
    }
}
