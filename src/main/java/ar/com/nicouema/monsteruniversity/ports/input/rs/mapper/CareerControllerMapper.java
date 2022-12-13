package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;

import ar.com.nicouema.monsteruniversity.domain.model.Career;

import ar.com.nicouema.monsteruniversity.ports.input.rs.request.CreateCareerRequest;

import ar.com.nicouema.monsteruniversity.ports.input.rs.response.CareerResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CareerControllerMapper {

    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audit", ignore = true)
    @Mapping(target = "degree", source = "degree")
    Career careerRequestToCareer(CreateCareerRequest careerRequest);

    List<CareerResponse> careerListToCareerListResponse(List<Career> careers);

}
