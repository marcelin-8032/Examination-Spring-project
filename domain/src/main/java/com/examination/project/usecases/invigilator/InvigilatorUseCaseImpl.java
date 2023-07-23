package com.examination.project.usecases.invigilator;


import com.examination.project.entities.Invigilator;
import com.examination.project.mapper.InvigilatorMapper;
import com.examination.project.handler.persistance.invigilator.repository.InvigilatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InvigilatorUseCaseImpl implements InvigilatorUseCase {

    private InvigilatorRepository invigilatorRepository;

    @Autowired
    private InvigilatorMapper invigilatorMapper;

    @Override
    public void createInvigilator(Invigilator invigilator) {
        invigilatorRepository.save(
                invigilatorMapper.toInvigilatorEntity(invigilator));

    }


}
