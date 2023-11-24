package com.algoritmos.dbtreeclient.usecase;

import com.algoritmos.dbtreeclient.domain.Book;

public interface DataUseCase {

    public void insert(Book data, String server);
    public Book search(String id, String server);
    public void delete(String id, String server);
}
