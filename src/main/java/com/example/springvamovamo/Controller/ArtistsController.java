package com.example.springvamovamo.Controller;

import com.example.springvamovamo.Entidades.ArtistsEntity;
import com.example.springvamovamo.Entidades.StringReponse;
import com.example.springvamovamo.Repository.ArtistsRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("artistas")
public class ArtistsController {
    @Autowired
    ArtistsRepository repositorio;
    @GetMapping("")
    List<ArtistsEntity> getAllArtists(){
        return repositorio.findAll();
    }
    @GetMapping("/{name}")
    List<ArtistsEntity> getArtistbyName(@PathVariable ("name") String Name){
        return repositorio.findByArtist(Name);
    }
    @PostMapping("")
    ResponseEntity<?> postArtista(@Valid @RequestBody ArtistsEntity nuevoArtista ){
        if(repositorio.existsByArtist(nuevoArtista.getArtist())){
        return new ResponseEntity<>(new StringReponse("Ya hay un artista por ese nombre"), HttpStatus.CONFLICT);


        }else{
            ArtistsEntity artistaGuardado = repositorio.save(nuevoArtista);
            return new ResponseEntity<>(artistaGuardado, HttpStatus.OK);
        }


    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteArtista(@PathVariable ("id") Integer idRecibida){
        if(repositorio.existsById(idRecibida)){
            String nombreArtista = repositorio.getById(idRecibida).getArtist();
            repositorio.deleteById(idRecibida);
            return new ResponseEntity<>("Se ha borrado el artista " + nombreArtista, HttpStatus.OK);

        }else{

            return new ResponseEntity<>(new StringReponse("No hay un artista con esa ID"), HttpStatus.CONFLICT);

        }
    }
    @PutMapping("/{id}")
    ResponseEntity<?> putArtista(@PathVariable ("id") Integer idRecibida, @Valid @RequestBody ArtistsEntity viejoArtista){
        if(repositorio.existsById(idRecibida)){
            ArtistsEntity  ArtistaEncontrado = repositorio.getById(idRecibida);
            String nombreArtista = ArtistaEncontrado.getArtist();
            ArtistaEncontrado.setArtist(viejoArtista.getArtist());
            repositorio.save(ArtistaEncontrado);

            return new ResponseEntity<>("Se ha actualizado el artista " + nombreArtista + ", a: " + ArtistaEncontrado.getArtist(), HttpStatus.OK);

        }else{

            return new ResponseEntity<>(new StringReponse("No hay un artista con esa ID"), HttpStatus.CONFLICT);

        }
    }

}
