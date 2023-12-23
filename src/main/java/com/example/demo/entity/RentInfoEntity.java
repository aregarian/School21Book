package com.example.demo.entity;


import jakarta.persistence.*;
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
@Entity
@Table(name = "rent_info")
public class RentInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "renter")
    private String renterName;

    @Column(name = "rent_got_time")
    private String rentGotTime;

    @Column(name = "rent_return_time")
    private String rentReturnTime;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<BookEntity> books;





}
