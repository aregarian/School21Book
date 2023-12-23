package com.example.demo.service;

import com.example.demo.dto.BookCreateRequestDto;
import com.example.demo.dto.BookRepresentationDto;
import com.example.demo.entity.BookEntity;
import com.example.demo.repository.BookRepository;

import com.example.demo.repository.RentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    private RentRepository rentRepository;



    public List<BookRepresentationDto> getAll() {
        return bookRepository.findAll().stream()
                .map(BookRepresentationDto::fromEntity)
                .toList();
    }

    public BookRepresentationDto getById(Long id) {
        return BookRepresentationDto.fromEntity(
                bookRepository.findById(id).orElseThrow()
        );
    }


    @Transactional
    public Long addBook(BookCreateRequestDto requestDto) {
        var newEntity = BookEntity.builder()
                .number(requestDto.getNumber())
                .name(requestDto.getName())
                .rentInfo(rentRepository.findAllByIdIn(requestDto.getRentIds()))
                .build();
        return BookRepresentationDto.fromEntity(bookRepository.save(newEntity)).getId();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<BookEntity> getByIds(List<Long> bookIds)  {
        return bookRepository.findAllById(bookIds);
    }


}
