package ar.com.nicouema.monsteruniversity.domain.usecase.impl;

import ar.com.nicouema.monsteruniversity.common.exception.NotFoundException;
import ar.com.nicouema.monsteruniversity.domain.model.Subject;
import ar.com.nicouema.monsteruniversity.domain.model.list.SubjectList;
import ar.com.nicouema.monsteruniversity.domain.repository.SubjectRepository;
import ar.com.nicouema.monsteruniversity.domain.usecase.SubjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repository;

    @Override
    @Transactional
    public Long createSubject(Subject subject) {
        return repository.save(subject).getId();
    }

    @Override
    public Subject getSubjectById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public SubjectList getAllSubjects(PageRequest request) {
        Page<Subject> page = repository.findAll(request);

        return new SubjectList(page.getContent(), request, page.getTotalElements());

    }
}
