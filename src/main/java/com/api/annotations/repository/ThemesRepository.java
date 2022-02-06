package com.api.annotations.repository;

import com.api.annotations.model.Themes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemesRepository extends JpaRepository<Themes, Long> {
    Themes findByTheme(String theme);
}
