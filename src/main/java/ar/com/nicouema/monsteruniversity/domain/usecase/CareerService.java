package ar.com.nicouema.monsteruniversity.domain.usecase;

import ar.com.nicouema.monsteruniversity.domain.model.Career;
import ar.com.nicouema.monsteruniversity.domain.model.CareerList;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CareerService {

    CareerList getAllCareers(PageRequest pageRequest);

    Long saveCareer(Career career);

}
