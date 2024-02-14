package com.example.springvamovamo.Entidades;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "artistid")
@Entity
@Table(name = "artists", schema = "pruebas", catalog = "")
public class ArtistsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "artistid", nullable = false)
    private int artistid;
    @Basic
    @Column(name = "artist", nullable = true, length = 66)
    private String artist;
    @JsonBackReference

    @ManyToOne ( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewid", referencedColumnName = "reviewid")
    private ReviewsEntity reviewsByReviewid;

    public ArtistsEntity() {

    }

    public ArtistsEntity(String artist) {
        this.artist = artist;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistsEntity that = (ArtistsEntity) o;

        if (artistid != that.artistid) return false;
        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = artistid;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        return result;
    }

    public ReviewsEntity getReviewsByReviewid() {
        return reviewsByReviewid;
    }

    public void setReviewsByReviewid(ReviewsEntity reviewsByReviewid) {
        this.reviewsByReviewid = reviewsByReviewid;
    }
}
