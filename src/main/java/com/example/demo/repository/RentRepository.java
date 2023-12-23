package com.example.demo.repository;

import com.example.demo.entity.RentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<RentInfoEntity,Long>{

    List<RentInfoEntity> findAllByIdIn(List<Long> ids);

}
