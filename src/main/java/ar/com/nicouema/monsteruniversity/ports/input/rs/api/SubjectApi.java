package ar.com.nicouema.monsteruniversity.ports.input.rs.api;

import ar.com.nicouema.monsteruniversity.ports.input.rs.request.SubjectRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectListResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectResponse;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface SubjectApi {

    ResponseEntity<SubjectListResponse> getAllSubjects(Optional<Integer> page, Optional<Integer> size);

    ResponseEntity<SubjectResponse> getSubjectById(Long id);

    ResponseEntity<SubjectResponse> createSubject(SubjectRequest request);
}
