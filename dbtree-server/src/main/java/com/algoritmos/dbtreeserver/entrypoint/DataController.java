package com.algoritmos.dbtreeserver.entrypoint;


import com.algoritmos.dbtreeserver.domain.Book;
import com.algoritmos.dbtreeserver.usecase.BTreeOperationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/data")
public class DataController {

    private final BTreeOperationUseCase bTreeOperationUseCase;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Book book) {
        bTreeOperationUseCase.insert(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> search(@PathVariable("id") String id) {
        return new ResponseEntity<>(bTreeOperationUseCase.search(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        bTreeOperationUseCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
