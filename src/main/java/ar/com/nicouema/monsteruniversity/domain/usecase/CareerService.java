package ar.com.nicouema.monsteruniversity.domain.usecase;

import ar.com.nicouema.monsteruniversity.domain.model.Career;
import ar.com.nicouema.monsteruniversity.domain.model.list.CareerList;
import org.springframework.data.domain.PageRequest;

public interface CareerService {

    CareerList getAllCareers(PageRequest pageRequest);

    Long saveCareer(Career career);

}
