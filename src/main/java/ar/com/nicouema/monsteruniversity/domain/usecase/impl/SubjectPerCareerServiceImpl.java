package ar.com.nicouema.monsteruniversity.domain.usecase.impl;

import ar.com.nicouema.monsteruniversity.common.exception.NotFoundException;
import ar.com.nicouema.monsteruniversity.domain.model.SubjectFromCareer;
import ar.com.nicouema.monsteruniversity.domain.model.list.SubjectFromCareerList;
import ar.com.nicouema.monsteruniversity.domain.model.ids.SubjectPerCareerId;
import ar.com.nicouema.monsteruniversity.domain.repository.SubjectPerCareerRepository;
import ar.com.nicouema.monsteruniversity.domain.usecase.SubjectPerCareerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectPerCareerServiceImpl implements SubjectPerCareerService {


    private final SubjectPerCareerRepository repository;

    @Override
    public SubjectFromCareer getSubjectFromCareer(SubjectPerCareerId id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public SubjectFromCareerList getSubjectsFromCareer(Long careerId, PageRequest pageRequest) {
        List<SubjectFromCareer> list =repository.findAll(pageRequest).stream()
                .filter(subject -> subject.getCareer().getId().equals(careerId)).toList();
        Page<SubjectFromCareer> page = new PageImpl<>(list);

        return new SubjectFromCareerList(page.getContent(), pageRequest, page.getTotalElements());
    }

    @Override
    @Transactional
    public SubjectFromCareer addSubjectToCareer(SubjectFromCareer subjectFromCareer) {
        return repository.save(subjectFromCareer);
    }

    @Override
    @Transactional
    public SubjectFromCareer updateSubjectFromCareer(SubjectPerCareerId id, SubjectFromCareer subject) {
        SubjectFromCareer subjectFromCareer = getSubjectFromCareer(id);
        repository.save(subject);
        subjectFromCareer.update(subject);
        return subjectFromCareer;
    }

    @Override
    @Transactional
    public void removeSubjectFromCareer(SubjectPerCareerId id) {
        repository.deleteById(id);
    }
}
