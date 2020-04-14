package com.ort.ortnct.entity;

import com.ort.ortnct.enums.ListOfVariant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "variants")
public class Variant
{
    @Column(name = "variant_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "variant")
    private ListOfVariant variant;

    @Getter
    @Setter
    @OneToMany(mappedBy = "variant")
    private List<Question> question = new ArrayList<>();
}
