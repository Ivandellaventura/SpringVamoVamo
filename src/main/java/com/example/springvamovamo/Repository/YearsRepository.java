package com.example.springvamovamo.Repository;

import com.example.springvamovamo.Entidades.ReviewsEntity;
import com.example.springvamovamo.Entidades.YearsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YearsRepository extends JpaRepository<YearsEntity, Integer> {

}
