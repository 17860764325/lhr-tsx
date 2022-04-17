package com.lhrtsx.study.dto;


import com.lhrtsx.study.enirty.Classification;
import lombok.Data;

import java.lang.instrument.ClassDefinition;
import java.util.List;

@Data
public class ClassificationDto {

    private Long id;

    private String name;

    private String about;

    private Long pid;

    private String ancestral;

    private List<ClassificationDto> children;
}
