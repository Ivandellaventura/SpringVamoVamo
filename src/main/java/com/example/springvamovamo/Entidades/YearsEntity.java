package com.example.springvamovamo.Entidades;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;


@Entity
@Table(name = "years", schema = "pruebas", catalog = "")@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "yearid")
public class YearsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "yearid", nullable = false)
    private int yearid;
    @Basic
    @Column(name = "year", nullable = true, length = 4)
    private String year;
    @JsonBackReference
    @ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewid", referencedColumnName = "reviewid")
    private ReviewsEntity reviewsByReviewid;

    public int getYearid() {
        return yearid;
    }

    public void setYearid(int yearid) {
        this.yearid = yearid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YearsEntity that = (YearsEntity) o;

        if (yearid != that.yearid) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = yearid;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    public ReviewsEntity getReviewsByReviewid() {
        return reviewsByReviewid;
    }

    public void setReviewsByReviewid(ReviewsEntity reviewsByReviewid) {
        this.reviewsByReviewid = reviewsByReviewid;
    }
}
