package com.algoritmos.dbtreeserver.usecase;

public interface BTreeOperationUseCase {
    String insert(Object data);
    String search(String id);
    String delete(String id);
}
