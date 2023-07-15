package com.cegefos.tp1.controller.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.cegefos.tp1.controller.ExamController;
import com.cegefos.tp1.persistance.mapper.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import com.cegefos.tp1.persistance.entities.RoomEntity;
import com.cegefos.tp1.service.ExamenService;

@RestController
public class ExamControllerImpl implements ExamController {

    @Autowired
    private ExamenService examenService;

    @Autowired
    private ExamMapper examMapper;

    @Override
    public void createExamens(@RequestBody List<ExamEntity> examenEntities) {
        examenService.createExamens(examenEntities);
    }

    @Override
    public Collection<ExamEntity> getAllExamens() {
        return examenService.getAllExamens();
    }

    @Override
    public Collection<ExamEntity> getExamensByDate(@RequestBody Date date) {
        return examenService.getExamensByDate(date);
    }

    @Override
    public Collection<ExamEntity> getExamAtSalleAndAfterADate(@RequestBody RoomEntity roomEntity, Date date) {
        return examenService.getExamAtSalleAndAfterADate(roomEntity, date);
    }

    @Override
    public Collection<ExamEntity> getExamensAtRecentDataAtSpecificSalle(@RequestBody RoomEntity roomEntity) {
        return examenService.getExamensAtRecentDataAtSpecificSalle(roomEntity);
    }

    @Override
    public Page<ExamEntity> getAllExamensInPages(@NotNull final Pageable pageable) {
        return examenService.getAllExamensInPages(pageable);
    }

    @Override
    public Page<ExamEntity> getAllExamensBySalle(@PathVariable("salleId") Integer salleId, @NotNull final Pageable pageable) {
        return examenService.getAllExamensBySalle(salleId, pageable);
    }

}
