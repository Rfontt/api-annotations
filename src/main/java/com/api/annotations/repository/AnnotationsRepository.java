package com.api.annotations.repository;

import com.api.annotations.model.Annotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnotationsRepository extends JpaRepository<Annotations, Long> {
    List<Annotations> findByTheme_Id(Long theme);
}
