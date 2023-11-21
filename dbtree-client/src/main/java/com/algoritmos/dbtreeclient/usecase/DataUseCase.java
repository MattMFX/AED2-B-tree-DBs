package com.algoritmos.dbtreeclient.usecase;

public interface DataUseCase {

    public String insert(Object data);
    public String search(String id);
    public String delete(String id);
}
