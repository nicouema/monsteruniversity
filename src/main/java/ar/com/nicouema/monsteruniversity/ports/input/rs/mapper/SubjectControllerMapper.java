package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;

import ar.com.nicouema.monsteruniversity.domain.model.Subject;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.SubjectRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface SubjectControllerMapper {

    SubjectResponse subjectToSubjectResponse(Subject subject);

    @Mapping(target = "audit", ignore = true)
    @Mapping(target = "id", ignore = true)
    Subject subjectRequestToSubject(SubjectRequest request);

    List<SubjectResponse> subjectListToSubjectListResponse(List<Subject> content);
}
