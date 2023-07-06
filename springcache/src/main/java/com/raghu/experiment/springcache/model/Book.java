package com.raghu.experiment.springcache.model;

import lombok.*;

@ToString
@Builder
public class Book {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String author;

    @Getter
    @Setter
    private String publication;

}
