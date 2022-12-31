package ar.com.nicouema.monsteruniversity.domain.usecase;

import ar.com.nicouema.monsteruniversity.domain.model.SubjectFromCareer;
import ar.com.nicouema.monsteruniversity.domain.model.list.SubjectFromCareerList;
import ar.com.nicouema.monsteruniversity.domain.model.ids.SubjectPerCareerId;
import org.springframework.data.domain.PageRequest;

public interface SubjectPerCareerService {

    SubjectFromCareer getSubjectFromCareer(SubjectPerCareerId id);

    SubjectFromCareerList getSubjectsFromCareer(Long careerIdm, PageRequest pageRequest);

    SubjectFromCareer addSubjectToCareer(SubjectFromCareer subjectFromCareer);

    SubjectFromCareer updateSubjectFromCareer(SubjectPerCareerId id, SubjectFromCareer subject);

    void removeSubjectFromCareer(SubjectPerCareerId id);

}
