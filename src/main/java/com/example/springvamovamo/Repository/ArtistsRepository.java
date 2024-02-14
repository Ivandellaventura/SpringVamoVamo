package com.example.springvamovamo.Repository;

import com.example.springvamovamo.Entidades.ArtistsEntity;
import com.example.springvamovamo.Entidades.ReviewsEntity;
import com.example.springvamovamo.Entidades.YearsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistsRepository extends JpaRepository<ArtistsEntity, Integer> {
    @Override
    List<ArtistsEntity> findAll();

    @Override
    List<ArtistsEntity> findAllById(Iterable<Integer> integers);
    List<ArtistsEntity> findByArtist(String Name);


    boolean existsByArtist(String artist);
}
