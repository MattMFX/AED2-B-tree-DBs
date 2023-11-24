package com.algoritmos.dbtreeserver.usecase.impl;

import com.algoritmos.dbtreeserver.domain.Book;
import com.algoritmos.dbtreeserver.usecase.BTreeOperationUseCase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvMalformedLineException;
import com.opencsv.exceptions.CsvValidationException;
import org.mapdb.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class BTreeOperationUseCaseImpl implements BTreeOperationUseCase {

    private static int MAX_NODE_SIZE = 100;

    @Override
    public void insert(Book book) {
        try (DB db = getDb()) {
            @SuppressWarnings("rawtypes")
            BTreeMap map = db.treeMap("map")
                    .keySerializer(Serializer.STRING)
                    .valueSerializer(Serializer.JAVA)
                    .maxNodeSize(MAX_NODE_SIZE)
                    .createOrOpen();

            long start = System.currentTimeMillis();
            map.put(book.getId(), book);
            long end = System.currentTimeMillis();

            System.out.println("Tempo de insercao: " + (end - start) + "ms");
        }
    }

    @Override
    public Book search(String id) {
        try (DB db = getDb()) {
            @SuppressWarnings("rawtypes")
            BTreeMap map = db.treeMap("map")
                    .keySerializer(Serializer.STRING)
                    .valueSerializer(Serializer.JAVA)
                    .maxNodeSize(MAX_NODE_SIZE)
                    .createOrOpen();

            long start = System.currentTimeMillis();
            Book book = (Book) map.get(id);
            long end = System.currentTimeMillis();

            System.out.println("Tempo de busca: " + (end - start) + "ms");

            return book;
        }
    }

    @Override
    public void delete(String id) {
        try (DB db = getDb()) {
            @SuppressWarnings("rawtypes")
            BTreeMap map = db.treeMap("map")
                    .keySerializer(Serializer.STRING)
                    .valueSerializer(Serializer.JAVA)
                    .maxNodeSize(MAX_NODE_SIZE)
                    .createOrOpen();

            long start = System.currentTimeMillis();
            map.remove(id);
            long end = System.currentTimeMillis();

            System.out.println("Tempo de remoção: " + (end - start) + "ms");
        }
    }

    public void bulkInsert() {
        String csvFilePath = "dataset.csv";

        try (DB db = getDb(); BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            BTreeMap map = db.treeMap("mapdb.db")
                    .keySerializer(Serializer.STRING)
                    .valueSerializer(Serializer.JAVA)
                    .maxNodeSize(MAX_NODE_SIZE)
                    .createOrOpen();

            String line;
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                try {
                    CSVReader csvReader = new CSVReader(new StringReader(line));
                    String[] values = csvReader.readNext();
                    Book book = buildBook(values);
                    map.put(book.getId(), book);
                } catch (CsvValidationException | CsvMalformedLineException | ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    System.out.println("Linha mal formada: " + line);
                } catch (NullPointerException ex) {
                    System.out.println("Linha nula encontrada");
                }
            }

            db.commit();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private DB getDb() {
        return DBMaker
                .fileDB("mapdbmax100.db")
                .fileMmapEnable()
                .fileMmapEnableIfSupported()
                .fileMmapPreclearDisable()
                .cleanerHackEnable()
                .checksumHeaderBypass()
                .closeOnJvmShutdown()
                .make();
    }

    private Book buildBook(String[] values) {

        return new Book(getList(values[0]), values[1], getList(values[2]), values[3], values[4], values[5], values[6], values[7], values[8], values[9],
                values[10], values[11], values[12], values[13], values[14], values[15], values[16], values[17], values[18], values[19],
                values[20], values[21], values[22], values[23], values[24], values[25], values[26], values[27]);
    }

    private List<String> getList(String value) {
        return Arrays.asList(value.replace("[", "").replace("]", "").trim().split(","));
    }

    public static void main(String[] args) {
        BTreeOperationUseCaseImpl impl = new BTreeOperationUseCaseImpl();
//        impl.bulkInsert();
        impl.insert(new Book(null, null, null, null, null, null, null, null, null,
                null, null, "724376219325", null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null));
        System.out.println(impl.search("724376219325"));
    }

}
