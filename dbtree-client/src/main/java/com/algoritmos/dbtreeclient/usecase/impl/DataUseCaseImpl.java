package com.algoritmos.dbtreeclient.usecase.impl;

import com.algoritmos.dbtreeclient.usecase.DataUseCase;
import org.springframework.stereotype.Service;

@Service
public class DataUseCaseImpl implements DataUseCase {

    @Override
    public String insert(Object data) {
        return "insert";
    }

    @Override
    public String search(String id) {
        return "search";
    }

    @Override
    public String delete(String id) {
        return "delete";
    }
}
