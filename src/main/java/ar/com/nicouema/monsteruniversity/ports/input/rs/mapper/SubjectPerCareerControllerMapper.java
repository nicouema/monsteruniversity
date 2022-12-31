package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;

import ar.com.nicouema.monsteruniversity.domain.model.SubjectFromCareer;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.AddSubjectToCareerRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.CareerResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectFromCareerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface SubjectPerCareerControllerMapper {

    @Mapping(target = "audit", ignore = true)
    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "career", ignore = true)
    @Mapping(target = "career.id", source = "careerId")
    SubjectFromCareer addSubjectToCareerToSubjectPerCareer(AddSubjectToCareerRequest request);

    @Mapping(target = "subjectId", source = "subject.id")
    @Mapping(target = "careerId", source = "career.id")
    SubjectFromCareerResponse subjectFromCareerToSubjectFromCareerResponse(SubjectFromCareer subjectFromCareer);

    List<SubjectFromCareerResponse> subjectFromCareerListToSubjectListResponse(List<SubjectFromCareer> content);
}
