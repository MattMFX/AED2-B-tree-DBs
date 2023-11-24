package com.algoritmos.dbtreeserver.usecase;

import com.algoritmos.dbtreeserver.domain.Book;

import java.io.IOException;

public interface BTreeOperationUseCase {
    void insert(Book book);
    Book search(String id);
    void delete(String id);
}
