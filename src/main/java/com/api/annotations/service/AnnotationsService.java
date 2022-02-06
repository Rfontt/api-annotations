package com.api.annotations.service;

import com.api.annotations.form.AnnotationsForm;
import com.api.annotations.model.Annotations;
import com.api.annotations.repository.AnnotationsRepository;
import com.api.annotations.repository.ThemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationsService {
    @Autowired
    private AnnotationsRepository annotationsRepository;
    @Autowired
    private ThemesRepository themesRepository;

    public Annotations save(AnnotationsForm form) {
        Annotations annotations = form.form(themesRepository);
        annotationsRepository.save(annotations);

        return annotations;
    }

    public List<Annotations> listByTheme(Long theme) {
       List<Annotations> annotations = annotationsRepository.findByTheme_Id(theme);

       return annotations;
    }
}
