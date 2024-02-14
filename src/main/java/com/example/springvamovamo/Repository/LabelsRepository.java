package com.example.springvamovamo.Repository;

import com.example.springvamovamo.Entidades.LabelsEntity;
import com.example.springvamovamo.Entidades.ReviewsEntity;
import com.example.springvamovamo.Entidades.YearsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabelsRepository extends JpaRepository<LabelsEntity, Integer> {

}
