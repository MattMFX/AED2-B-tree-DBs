package com.algoritmos.dbtreeclient.entrypoint;

import com.algoritmos.dbtreeclient.usecase.DataUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController(value = "/data")
public class DataController {

    private final DataUseCase dataUseCase;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Object data) {
        return new ResponseEntity<>(dataUseCase.insert(data), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> search(@PathVariable("id") String id) {
        return new ResponseEntity<>(dataUseCase.search(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        return new ResponseEntity<>(dataUseCase.delete(id), HttpStatus.OK);
    }
}
