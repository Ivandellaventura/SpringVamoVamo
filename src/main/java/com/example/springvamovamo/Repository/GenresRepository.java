package com.example.springvamovamo.Repository;

import com.example.springvamovamo.Entidades.GenresEntity;
import com.example.springvamovamo.Entidades.ReviewsEntity;
import com.example.springvamovamo.Entidades.YearsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenresRepository extends JpaRepository<GenresEntity, Integer> {
    @Override
    List<GenresEntity> findAll();

    @Override
    List<GenresEntity> findAllById(Iterable<Integer> integers);
}
