package com.algoritmos.dbtreeserver.entrypoint;


import com.algoritmos.dbtreeserver.usecase.BTreeOperationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController(value = "/data")
public class DataController {

    private final BTreeOperationUseCase bTreeOperationUseCase;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Object data) {
        return new ResponseEntity<>(bTreeOperationUseCase.insert(data), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> search(@PathVariable("id") String id) {
        return new ResponseEntity<>(bTreeOperationUseCase.search(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        return new ResponseEntity<>(bTreeOperationUseCase.delete(id), HttpStatus.OK);
    }
}
