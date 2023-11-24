package com.algoritmos.dbtreeclient.entrypoint;

import com.algoritmos.dbtreeclient.domain.Book;
import com.algoritmos.dbtreeclient.usecase.DataUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/data")
public class DataController {

    private final DataUseCase dataUseCase;

    @PostMapping("/{server}")
    public ResponseEntity<Void> insert(@RequestBody Book data, @PathVariable("server") String server) {
        try {
            dataUseCase.insert(data, server);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/{server}")
    public ResponseEntity<Book> search(@PathVariable("id") String id, @PathVariable("server") String server) {
        try {

            return new ResponseEntity<>(dataUseCase.search(id, server), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}/{server}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id, @PathVariable("server") String server) {
        try {
            dataUseCase.delete(id, server);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
