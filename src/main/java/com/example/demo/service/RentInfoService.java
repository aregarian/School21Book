package com.example.demo.service;


import com.example.demo.dto.RentInfoCreateDto;
import com.example.demo.dto.RentInfoRepresentationDto;
import com.example.demo.entity.RentInfoEntity;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.RentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentInfoService {

    private RentRepository rentRepository;

    private BookService bookService;

    @Transactional
    public Long createRent(RentInfoCreateDto requestDto) {
        var entity = RentInfoEntity.builder()
                .renterName(requestDto.getRenterName())
                .rentGotTime(requestDto.getRentGotTime())
                .rentReturnTime(requestDto.getRentReturnTime())
                .books(bookService.getByIds(requestDto.getBookIds()))
                .build();
        return RentInfoRepresentationDto.fromEntity(rentRepository.save(entity)).getId();

    }

    public List<RentInfoRepresentationDto> getByBookId(Long bookId) {
        return bookService.getById(bookId).getRentInfos();
    }

}
