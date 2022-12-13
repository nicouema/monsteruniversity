package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;

import ar.com.nicouema.monsteruniversity.domain.model.Career;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.CreateCareerRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.CareerResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class CareerControllerMapperImpl implements CareerControllerMapper {

    @Override
    public Career careerRequestToCareer(CreateCareerRequest careerRequest) {
        if ( careerRequest == null ) {
            return null;
        }

        Career career = new Career();

        career.setDegree( careerRequest.getDegree() );

        return career;
    }

    @Override
    public List<CareerResponse> careerListToCareerListResponse(List<Career> careers) {
        if ( careers == null ) {
            return null;
        }

        List<CareerResponse> list = new ArrayList<CareerResponse>( careers.size() );
        for ( Career career : careers ) {
            list.add( careerToCareerResponse( career ) );
        }

        return list;
    }

    protected CareerResponse careerToCareerResponse(Career career) {
        if ( career == null ) {
            return null;
        }

        CareerResponse.CareerResponseBuilder careerResponse = CareerResponse.builder();

        careerResponse.degree( career.getDegree() );

        return careerResponse.build();
    }
}
