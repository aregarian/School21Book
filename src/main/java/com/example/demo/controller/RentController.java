package com.example.demo.controller;

import com.example.demo.dto.BookRepresentationDto;
import com.example.demo.dto.RentInfoCreateDto;
import com.example.demo.dto.RentInfoRepresentationDto;
import com.example.demo.service.RentInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/rent")
@AllArgsConstructor
public class RentController {

    private RentInfoService rentInfoService;

    @PostMapping
    public ResponseEntity<String> createRent(@RequestBody RentInfoCreateDto requestDto) {
        return ResponseEntity.ok(rentInfoService.createRent(requestDto).toString());
    }

    @GetMapping("/byBook/{bookId}")
    public ResponseEntity<List<RentInfoRepresentationDto>> getByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok(rentInfoService.getByBookId(bookId));
    }

}
