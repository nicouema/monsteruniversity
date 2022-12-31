package ar.com.nicouema.monsteruniversity.ports.input.rs.api;


import ar.com.nicouema.monsteruniversity.ports.input.rs.request.AddSubjectToCareerRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectFromCareerListResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectFromCareerResponse;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface SubjectPerCareerApi {

    ResponseEntity<SubjectFromCareerResponse> getSubjectFromCareer(Long careerId, Long subjectId);

    ResponseEntity<SubjectFromCareerListResponse> getSubjectsFromACareer(Long careerId,
                                                                         Optional<Integer> page,
                                                                         Optional<Integer> size);

    ResponseEntity<SubjectFromCareerResponse> addSubjectToCareer(Long careerId,
                                                                 Long subjectId,
                                                                 AddSubjectToCareerRequest request);
}
