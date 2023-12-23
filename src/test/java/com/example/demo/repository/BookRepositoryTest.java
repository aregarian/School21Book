package com.example.demo.repository;


import com.example.demo.entity.BookEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BookRepositoryTest {


    @Autowired
    private BookRepository bookRepository;

    @Test
    public void bookRepoTest_SaveAll_ReturnSaveBook(){

        BookEntity book = BookEntity.builder()
                .name("Martin Iden")
                .number("1")
                .build();


        BookEntity saveBookEntity = bookRepository.save(book);


        Assertions.assertThat(saveBookEntity).isNotNull();
        Assertions.assertThat(saveBookEntity.getId()).isGreaterThan(0);

    }
    
    @Test
    public void BookRepo_GetAll_ReturnMoreThanOne() {
        BookEntity book = BookEntity.builder()
                .name("Java for beginners")
                .number("2").build();


        BookEntity book2 = BookEntity.builder()
                .name("Swift for beginners")
                .number("3").build();


        bookRepository.save(book);
        bookRepository.save(book2);

        List<BookEntity> bookEntityList = bookRepository.findAll();

        Assertions.assertThat(bookEntityList).isNotNull();
        Assertions.assertThat(bookEntityList.size()).isEqualTo(2);
    }

    @Test
    public void BookRepo_GetById_ReturnBook() {
        BookEntity book = BookEntity.builder()
                .name("Java for beginners")
                .number("2").build();


        bookRepository.save(book);


        BookEntity bookEntityList = bookRepository.findById(book.getId()).get();

        Assertions.assertThat(bookEntityList).isNotNull();
    }

    @Test
    public void BookRepo_findByNumber_ReturnBookIsNotNull() {
        BookEntity book = BookEntity.builder()
                .name("Java for beginners")
                .number("2").build();


        bookRepository.save(book);


        BookEntity bookEntityList = bookRepository.findByNumber(book.getNumber()).get();

        Assertions.assertThat(bookEntityList).isNotNull();
    }

    @Test
    public void BookRepo_UpdateBook_ReturnBookIsNotNull() {
        BookEntity book = BookEntity.builder()
                .name("Java for beginners")
                .number("2").build();


        bookRepository.save(book);

        BookEntity bookSave = bookRepository.findById(book.getId()).get();

        bookSave.setName("Java");
        bookSave.setNumber("5");

        BookEntity updatedBook = bookRepository.save(bookSave);




        Assertions.assertThat(updatedBook.getName()).isNotNull();
        Assertions.assertThat(updatedBook.getNumber()).isNotNull();
    }



    @Test
    public void BookRepo_BookDelete_ReturnBookIsNotNull() {
        BookEntity book = BookEntity.builder()
                .name("Java for beginners")
                .number("2").build();


        bookRepository.save(book);

        bookRepository.deleteById(book.getId());


        Optional<BookEntity> bookReturn = bookRepository.findById(book.getId());



        Assertions.assertThat(bookReturn).isEmpty();

    }



}
