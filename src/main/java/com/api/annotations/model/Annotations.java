package com.api.annotations.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@Setter
public class Annotations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Themes theme;
    @Column(nullable = false)
    private String phase;

    public Annotations() {}

    public Annotations(Themes theme, String phase) {
        this.theme = theme;
        this.phase = phase;
    }
}