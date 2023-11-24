package com.algoritmos.dbtreeclient.usecase.impl;

import com.algoritmos.dbtreeclient.domain.Book;
import com.algoritmos.dbtreeclient.gateway.DataGateway;
import com.algoritmos.dbtreeclient.usecase.DataUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataUseCaseImpl implements DataUseCase {

    private final DataGateway dataGateway;

    @Override
    public void insert(Book data, String server) {
        dataGateway.insert(data, server);
    }

    @Override
    public Book search(String id, String server) {
        return dataGateway.search(id, server);
    }

    @Override
    public void delete(String id, String server) {
        dataGateway.delete(id, server);
    }
}
