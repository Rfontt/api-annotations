package com.api.annotations.dto;

import com.api.annotations.model.Annotations;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AnnotationsDTO {
    private Long id;
    private Long theme;
    private String phase;

    public AnnotationsDTO(Annotations annotations) {
        this.id = annotations.getId();
        this.theme = annotations.getTheme().getId();
        this.phase = annotations.getPhase();
    }

    public List<AnnotationsDTO> convert(List<Annotations> annotationsList) {
        return annotationsList.stream().map(AnnotationsDTO::new).collect(Collectors.toList());
    }
}
