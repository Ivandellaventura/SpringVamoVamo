package com.example.springvamovamo.Entidades;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;


@Entity
@Table(name = "labels", schema = "pruebas", catalog = "")@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "labelid")
public class LabelsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "labelid", nullable = false)
    private int labelid;
    @Basic
    @Column(name = "label", nullable = true, length = 34)
    private String label;
    @JsonBackReference
    @ManyToOne ( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewid", referencedColumnName = "reviewid")
    private ReviewsEntity reviewsByReviewid;

    public int getLabelid() {
        return labelid;
    }

    public void setLabelid(int labelid) {
        this.labelid = labelid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabelsEntity that = (LabelsEntity) o;

        if (labelid != that.labelid) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labelid;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    public ReviewsEntity getReviewsByReviewid() {
        return reviewsByReviewid;
    }

    public void setReviewsByReviewid(ReviewsEntity reviewsByReviewid) {
        this.reviewsByReviewid = reviewsByReviewid;
    }
}
