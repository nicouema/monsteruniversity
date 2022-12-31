package ar.com.nicouema.monsteruniversity.domain.usecase;

import ar.com.nicouema.monsteruniversity.domain.model.Subject;
import ar.com.nicouema.monsteruniversity.domain.model.list.SubjectList;
import org.springframework.data.domain.PageRequest;

public interface SubjectService {

    Long createSubject(Subject subject);

    Subject getSubjectById(Long id);

    SubjectList getAllSubjects(PageRequest pageRequest);


}
