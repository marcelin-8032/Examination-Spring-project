package com.examination.project.infrastructure.config.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.MapperFeature.USE_ANNOTATIONS;

public class ObjectMapperConfiguration implements WebMvcConfigurer {

    public ObjectMapper objectMapper(){

       return JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .addModule(new VavrModule())
                .configure(USE_ANNOTATIONS, false)
                .serializationInclusion(NON_NULL)
                .build();
    }
}
