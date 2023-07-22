package com.examination.project.usecases.invigilator;


import com.examination.project.entities.Invigilator;
import com.examination.project.mapper.InvigilatorMapper;
import com.examination.project.handler.persistance.invigilator.repository.InvigilatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvigilatorUseCaseImpl implements InvigilatorUseCase {

    private final InvigilatorRepository invigilatorRepository;

    private final InvigilatorMapper invigilatorMapper;

    @Override
    public void createInvigilator(Invigilator invigilator) {
        invigilatorRepository.save(
                invigilatorMapper.toInvigilatorEntity(invigilator));

    }


}
