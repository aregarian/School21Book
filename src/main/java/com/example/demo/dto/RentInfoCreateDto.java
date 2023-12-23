package com.example.demo.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentInfoCreateDto {
    @NotNull
    private String renterName;

    @NotNull
    private String rentGotTime;

    private String rentReturnTime;

    private List<Long> bookIds;

}
