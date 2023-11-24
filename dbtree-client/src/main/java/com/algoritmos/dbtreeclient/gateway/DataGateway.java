package com.algoritmos.dbtreeclient.gateway;

import com.algoritmos.dbtreeclient.domain.Book;
import org.springframework.http.ResponseEntity;

public interface DataGateway {

        public void insert(Book data, String server);
        public Book search(String id, String server);
        public void delete(String id, String server);
}
