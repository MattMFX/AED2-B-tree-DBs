package com.algoritmos.dbtreeclient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Book implements Serializable {
    private List<String> authors;
    private String bestsellerRank;
    private List<String> categories;
    private String description;
    private String dimensionsX;
    private String dimensionsY;
    private String dimensionsZ;
    private String edition;
    private String editionStatement;
    private String forAges;
    private String format;
    private String id;
    private String illustrationsNote;
    private String imageChecksum;
    private String imagePath;
    private String imageUrl;
    private String imprint;
    private String indexDate;
    private String isbn10;
    private String isbn13;
    private String language;
    private String publicationDate;
    private String publicationPlace;
    private String ratingAvarege;
    private String ratingCount;
    private String title;
    private String url;
    private String weight;
}
