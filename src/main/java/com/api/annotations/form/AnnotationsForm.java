package com.api.annotations.form;

import com.api.annotations.model.Annotations;
import com.api.annotations.model.Themes;
import com.api.annotations.repository.ThemesRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnotationsForm {
    private String phase;
    private String theme;

    public Annotations form(ThemesRepository themesRepository) {
        Themes themeName = themesRepository.findByTheme(theme);

        return new Annotations(themeName, phase);
    }
}
