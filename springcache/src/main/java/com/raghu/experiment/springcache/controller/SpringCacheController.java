package com.raghu.experiment.springcache.controller;

import com.raghu.experiment.springcache.model.Book;
import com.raghu.experiment.springcache.service.SpringCacheServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("cache-experiment")
public class SpringCacheController {

    Logger logger = LoggerFactory.getLogger(SpringCacheController.class);

    @Autowired
    SpringCacheServices springCacheServices;

    @GetMapping(value = "/books", produces = { APPLICATION_JSON_VALUE })
    public List<Book> getBooks() {
        logger.info("getBooks invoked");
        return springCacheServices.getBooks();
    }

    @GetMapping(value = "/book/{id}", produces = { APPLICATION_JSON_VALUE })
    public List<Book> getBooksById(@PathVariable int id) {
        logger.info("getBooksById invoked with id {}", id);
        return springCacheServices.getBooksById(id);
    }
}
