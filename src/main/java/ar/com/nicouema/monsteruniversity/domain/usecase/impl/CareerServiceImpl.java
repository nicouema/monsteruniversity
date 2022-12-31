package ar.com.nicouema.monsteruniversity.domain.usecase.impl;

import ar.com.nicouema.monsteruniversity.domain.model.Career;
import ar.com.nicouema.monsteruniversity.domain.model.list.CareerList;
import ar.com.nicouema.monsteruniversity.domain.repository.CareerRepository;
import ar.com.nicouema.monsteruniversity.domain.usecase.CareerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;

    @Override
    public CareerList getAllCareers(PageRequest pageRequest) {
        Page<Career> page = careerRepository.findAll(pageRequest);
        return new CareerList(page.getContent(), pageRequest, page.getTotalElements());
    }

    @Override
    @Transactional
    public Long saveCareer(Career career) {
        return careerRepository.save(career).getId();
    }
}
