package com.example.springvamovamo.Repository;

import com.example.springvamovamo.Entidades.ReviewsEntity;
import com.example.springvamovamo.Entidades.YearsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ReviewsRepository extends PagingAndSortingRepository<ReviewsEntity, Integer> {


    Page<ReviewsEntity> findAll();

    Page<ReviewsEntity> getAllByScoreGreaterThan(Pageable pageable, BigDecimal score);
    Page<ReviewsEntity> findAllByOrderByScore(Pageable pageable);

}
