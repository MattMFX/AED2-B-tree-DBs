package com.algoritmos.dbtreeclient.gateway.impl;

import com.algoritmos.dbtreeclient.gateway.DataGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class DataGatewayImpl implements DataGateway {

    private final RestTemplate restTemplate;

    @Override
    public String insert(Object data) {
        return null;
    }

    @Override
    public String search(String id) {
        return null;
    }

    @Override
    public String delete(String id) {
        return null;
    }
}
