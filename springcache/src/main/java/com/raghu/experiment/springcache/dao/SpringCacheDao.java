package com.raghu.experiment.springcache.dao;

import com.raghu.experiment.springcache.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpringCacheDao
{
    private static final List<Book> books = new ArrayList<>();
    static {
        Book book1 = Book.builder().id(101).name("Book 1").author("Author 1").publication("publication 1").build();
        Book book2 = Book.builder().id(102).name("Book 2").author("Author 2").publication("publication 2").build();
        Book book3 = Book.builder().id(103).name("Book 3").author("Author 3").publication("publication 3").build();
        Book book4 = Book.builder().id(104).name("Book 4").author("Author 4").publication("publication 4").build();
        Book book5 = Book.builder().id(105).name("Book 5").author("Author 5").publication("publication 5").build();
        Book book6 = Book.builder().id(106).name("Book 6").author("Author 6").publication("publication 6").build();
        Book book7 = Book.builder().id(107).name("Book 7").author("Author 7").publication("publication 7").build();
        books.add(book1);books.add(book2);books.add(book3);books.add(book4);books.add(book5);books.add(book6);books.add(book7);
    }

    @Cacheable(value="bookCache")
    public List<Book> getBooks(){
     return books;
    }

    @Cacheable(value="bookIdCache", key = "#id", sync = true)
    public List<Book> getBooksById(int id){
        return books.stream().filter(book -> book.getId() == id).collect(Collectors.toList());
    }

}
