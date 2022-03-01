package br.dev.thinkers.promotions.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Promotion> promotions = new ArrayList<>();
}
