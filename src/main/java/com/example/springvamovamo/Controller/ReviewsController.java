package com.example.springvamovamo.Controller;

import com.example.springvamovamo.Entidades.ArtistsEntity;
import com.example.springvamovamo.Entidades.ReviewsEntity;
import com.example.springvamovamo.Repository.ArtistsRepository;
import com.example.springvamovamo.Repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewsController {
    @Autowired
    ReviewsRepository repositorio;
    @GetMapping("")
    Page<ReviewsEntity> getAllReviewsPaginadas(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size){
        Pageable pagina = PageRequest.of(page, size);
        return repositorio.findAll(pagina);
    }
    @GetMapping("/ordenadas")
    Page<ReviewsEntity> getAllReviewsPaginadasOrdenadas(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size){
        Pageable pagina = PageRequest.of(page, size);
        return repositorio.findAllByOrderByScore(pagina);
    }
    @GetMapping("/filtrarPuntuacion")
    Page<ReviewsEntity> getReviewsByFilter(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "0") BigDecimal score){
        Pageable pagina = PageRequest.of(page, size);
        return repositorio.getAllByScoreGreaterThan(pagina,score);
    }





}
