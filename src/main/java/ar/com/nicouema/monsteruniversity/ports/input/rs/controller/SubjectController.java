package ar.com.nicouema.monsteruniversity.ports.input.rs.controller;

import ar.com.nicouema.monsteruniversity.domain.model.Subject;
import ar.com.nicouema.monsteruniversity.domain.model.list.SubjectList;
import ar.com.nicouema.monsteruniversity.domain.usecase.SubjectService;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.SubjectApi;
import ar.com.nicouema.monsteruniversity.ports.input.rs.mapper.SubjectControllerMapper;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.SubjectRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectListResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.SUBJECT_URI;
import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.uriByPageAsString;


@RestController
@RequestMapping(SUBJECT_URI)
@RequiredArgsConstructor
public class SubjectController implements SubjectApi {

    private final SubjectService service;
    private final SubjectControllerMapper mapper;

    @Override
    @GetMapping
    public ResponseEntity<SubjectListResponse> getAllSubjects(@RequestParam Optional<Integer> page,
                                                              @RequestParam Optional<Integer> size) {
        final int pageNumber = page.filter(p -> p > 0).orElse(ApiConstants.DEFAULT_PAGE);
        final int pageSize = page.filter(s -> s > 0).orElse(ApiConstants.DEFAULT_PAGE_SIZE);

        SubjectList list = service.getAllSubjects(PageRequest.of(pageNumber, pageSize));

        SubjectListResponse response = createResponse(list);

        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> getSubjectById(@PathVariable Long id) {

        Subject subject = service.getSubjectById(id);
        SubjectResponse response = mapper.subjectToSubjectResponse(subject);

        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping
    public ResponseEntity<SubjectResponse> createSubject(@RequestBody SubjectRequest request) {

        Subject subject = mapper.subjectRequestToSubject(request);
        Long id = service.createSubject(subject);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    public SubjectListResponse createResponse(SubjectList list) {

        SubjectListResponse response;
        {
            response = new SubjectListResponse();
            List<SubjectResponse> content = mapper.subjectListToSubjectListResponse(list.getContent());
            response.setContent(content);

            final int nextPage = list.getPageable().next().getPageNumber();
            response.setNextUri(uriByPageAsString.apply(nextPage));

            final int previousPage = list.getPageable().previousOrFirst().getPageNumber();
            response.setPreviousUri(uriByPageAsString.apply(previousPage));

            response.setTotalElements(list.getTotalElements());
            response.setTotalPages(list.getTotalPages());
        }
        return response;
    }

}
