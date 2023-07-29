package com.examination.project.usecases.subject;

import java.util.Collection;
import java.util.Optional;

import com.examination.project.entities.Subject;
import org.springframework.data.domain.Example;

public interface SubjectUseCase {

	void createSubject(Subject subject);
	
	void updateSubject(Integer id, int coefficient) throws Exception;
	
	Collection<Subject> getSubjectsGreaterThanACoefficient(int coefficient);
	
	Optional<Subject> getSubjectByExample(Example<?> example);
	
	Optional<Subject> getSubjectByCoefficient(Example<?> example);
	
	Optional<Subject> getSubjectByTitleWithIgnoreCase(Example<?> example);
	
	Collection<Subject> getAllSubjects();
	
	Collection<Subject> getSubjectCoeffBiggerIntituleEqDataModuleEq2(int coeff, Module module);
	
	Collection<Subject> getSubjectCoeffBiggerThanModuleEq2(int coeff, Module module);
	
	Collection<Subject> getSubjectTitleEqDataModuleEq2(Module module);
}
