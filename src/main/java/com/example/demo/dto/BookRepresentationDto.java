package com.example.demo.dto;

import com.example.demo.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRepresentationDto {
    private Long id;
    private String number;
    private String name;
    private List<RentInfoRepresentationDto> rentInfos;

    public static BookRepresentationDto fromEntity(BookEntity entity) {
        return BookRepresentationDto.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .name(entity.getName())
                .rentInfos(entity.getRentInfo().stream().map(RentInfoRepresentationDto::fromEntity).toList())
                .build();
    }
}
