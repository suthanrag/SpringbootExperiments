package com.raghu.experiment.springcache.service;

import com.raghu.experiment.springcache.controller.SpringCacheController;
import com.raghu.experiment.springcache.dao.SpringCacheDao;
import com.raghu.experiment.springcache.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringCacheServices {

    Logger logger = LoggerFactory.getLogger(SpringCacheServices.class);
    @Autowired
    SpringCacheDao springCacheDao;

    public List<Book> getBooks(){
        return springCacheDao.getBooks();
    }

    public List<Book> getBooksById(int id){
        return springCacheDao.getBooksById(id);
    }

 }
