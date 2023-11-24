package com.algoritmos.dbtreeclient.gateway.impl;

import com.algoritmos.dbtreeclient.domain.Book;
import com.algoritmos.dbtreeclient.gateway.DataGateway;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class DataGatewayImpl implements DataGateway {

    private final RestTemplate restTemplate;

    @Override
    public void insert(Book data, String server) {
        HttpEntity<Book> request = new HttpEntity<>(data);
        ResponseEntity<Void> book = restTemplate.exchange(String.format("http://%s/data", server), HttpMethod.POST, request, Void.class);
        System.out.println("Inserted book: " + book.getBody());
    }

    @Override
    public Book search(String id, String server) {
        Book book = restTemplate.getForObject(String.format("http://%s/data/%s", server, id), Book.class);
        System.out.println("Got book: " + book);

        return book;
    }

    @Override
    public void delete(String id, String server) {
        restTemplate.delete(String.format("http://%s/data/%s", server, id), String.class);
        System.out.println("Deleted " + id + " from server");
    }
}
