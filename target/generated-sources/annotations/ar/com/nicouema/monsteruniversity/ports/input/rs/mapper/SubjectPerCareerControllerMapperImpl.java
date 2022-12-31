package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;

import ar.com.nicouema.monsteruniversity.domain.model.Career;
import ar.com.nicouema.monsteruniversity.domain.model.Subject;
import ar.com.nicouema.monsteruniversity.domain.model.SubjectFromCareer;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.AddSubjectToCareerRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectFromCareerResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class SubjectPerCareerControllerMapperImpl implements SubjectPerCareerControllerMapper {

    @Override
    public SubjectFromCareer addSubjectToCareerToSubjectPerCareer(AddSubjectToCareerRequest request) {
        if ( request == null ) {
            return null;
        }

        SubjectFromCareer subjectFromCareer = new SubjectFromCareer();

        subjectFromCareer.setSubject( addSubjectToCareerRequestToSubject( request ) );
        subjectFromCareer.setCareer( addSubjectToCareerRequestToCareer( request ) );
        subjectFromCareer.setDescription( request.getDescription() );
        subjectFromCareer.setYear( request.getYear() );
        subjectFromCareer.setQuarter( request.getQuarter() );
        subjectFromCareer.setCondition( request.getCondition() );

        return subjectFromCareer;
    }

    @Override
    public SubjectFromCareerResponse subjectFromCareerToSubjectFromCareerResponse(SubjectFromCareer subjectFromCareer) {
        if ( subjectFromCareer == null ) {
            return null;
        }

        SubjectFromCareerResponse.SubjectFromCareerResponseBuilder subjectFromCareerResponse = SubjectFromCareerResponse.builder();

        subjectFromCareerResponse.subjectId( subjectFromCareerSubjectId( subjectFromCareer ) );
        subjectFromCareerResponse.careerId( subjectFromCareerCareerId( subjectFromCareer ) );
        subjectFromCareerResponse.description( subjectFromCareer.getDescription() );
        subjectFromCareerResponse.year( subjectFromCareer.getYear() );
        subjectFromCareerResponse.quarter( subjectFromCareer.getQuarter() );
        subjectFromCareerResponse.condition( subjectFromCareer.getCondition() );

        return subjectFromCareerResponse.build();
    }

    @Override
    public List<SubjectFromCareerResponse> subjectFromCareerListToSubjectListResponse(List<SubjectFromCareer> content) {
        if ( content == null ) {
            return null;
        }

        List<SubjectFromCareerResponse> list = new ArrayList<SubjectFromCareerResponse>( content.size() );
        for ( SubjectFromCareer subjectFromCareer : content ) {
            list.add( subjectFromCareerToSubjectFromCareerResponse( subjectFromCareer ) );
        }

        return list;
    }

    protected Subject addSubjectToCareerRequestToSubject(AddSubjectToCareerRequest addSubjectToCareerRequest) {
        if ( addSubjectToCareerRequest == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setId( addSubjectToCareerRequest.getSubjectId() );

        return subject;
    }

    protected Career addSubjectToCareerRequestToCareer(AddSubjectToCareerRequest addSubjectToCareerRequest) {
        if ( addSubjectToCareerRequest == null ) {
            return null;
        }

        Career career = new Career();

        career.setId( addSubjectToCareerRequest.getCareerId() );

        return career;
    }

    private Long subjectFromCareerSubjectId(SubjectFromCareer subjectFromCareer) {
        if ( subjectFromCareer == null ) {
            return null;
        }
        Subject subject = subjectFromCareer.getSubject();
        if ( subject == null ) {
            return null;
        }
        Long id = subject.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long subjectFromCareerCareerId(SubjectFromCareer subjectFromCareer) {
        if ( subjectFromCareer == null ) {
            return null;
        }
        Career career = subjectFromCareer.getCareer();
        if ( career == null ) {
            return null;
        }
        Long id = career.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
