package com.api.annotations.controller;

import com.api.annotations.dto.AnnotationsDTO;
import com.api.annotations.form.AnnotationsForm;
import com.api.annotations.model.Annotations;
import com.api.annotations.service.AnnotationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/annotations")
public class AnnotationsController {
    @Autowired
    private AnnotationsService annotationsService;

    @PostMapping
    public ResponseEntity<AnnotationsDTO> save(@RequestBody AnnotationsForm form, UriComponentsBuilder uriComponentsBuilder) {
        Annotations annotations = annotationsService.save(form);

        URI uri = uriComponentsBuilder.path("/annotations/{id}").buildAndExpand(annotations.getId()).toUri();

        return ResponseEntity.created(uri).body(new AnnotationsDTO(annotations));
    }

    @GetMapping("/{theme}")
    public ResponseEntity listByTheme(@PathVariable Long theme) {
        List<Annotations> annotations = annotationsService.listByTheme(theme);

        if (annotations == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(annotations);
    }
}
