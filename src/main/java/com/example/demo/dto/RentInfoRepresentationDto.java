package com.example.demo.dto;

import com.example.demo.entity.RentInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentInfoRepresentationDto {
    private Long id;
    private String renterName;
    private String rentGotTime;
    private String rentReturnTime;

    public static RentInfoRepresentationDto fromEntity(RentInfoEntity entity) {
        return RentInfoRepresentationDto.builder()
                .id(entity.getId())
                .renterName(entity.getRenterName())
                .rentGotTime(entity.getRentGotTime())
                .rentReturnTime(entity.getRentReturnTime())
                .build();

    }
}
