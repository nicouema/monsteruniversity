package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;

import ar.com.nicouema.monsteruniversity.domain.model.Subject;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.SubjectRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class SubjectControllerMapperImpl implements SubjectControllerMapper {

    @Override
    public SubjectResponse subjectToSubjectResponse(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectResponse.SubjectResponseBuilder subjectResponse = SubjectResponse.builder();

        subjectResponse.name( subject.getName() );

        return subjectResponse.build();
    }

    @Override
    public Subject subjectRequestToSubject(SubjectRequest request) {
        if ( request == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setName( request.getName() );

        return subject;
    }

    @Override
    public List<SubjectResponse> subjectListToSubjectListResponse(List<Subject> content) {
        if ( content == null ) {
            return null;
        }

        List<SubjectResponse> list = new ArrayList<SubjectResponse>( content.size() );
        for ( Subject subject : content ) {
            list.add( subjectToSubjectResponse( subject ) );
        }

        return list;
    }
}
