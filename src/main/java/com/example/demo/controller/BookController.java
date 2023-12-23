package com.example.demo.controller;

import com.example.demo.dto.BookCreateRequestDto;
import com.example.demo.dto.BookRepresentationDto;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookRepresentationDto>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookCreateRequestDto requestDto) {
        return ResponseEntity.ok(bookService.addBook(requestDto).toString());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
