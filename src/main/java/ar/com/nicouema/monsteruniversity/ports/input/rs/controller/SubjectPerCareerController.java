package ar.com.nicouema.monsteruniversity.ports.input.rs.controller;

import ar.com.nicouema.monsteruniversity.domain.model.SubjectFromCareer;
import ar.com.nicouema.monsteruniversity.domain.model.ids.SubjectPerCareerId;
import ar.com.nicouema.monsteruniversity.domain.model.list.SubjectFromCareerList;
import ar.com.nicouema.monsteruniversity.domain.usecase.SubjectPerCareerService;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.SubjectPerCareerApi;
import ar.com.nicouema.monsteruniversity.ports.input.rs.mapper.SubjectPerCareerControllerMapper;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.AddSubjectToCareerRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectFromCareerListResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.SubjectFromCareerResponse;
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

import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.SUBJECT_FROM_CAREER_URI;
import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.uriByPageAsString;

@RestController
@RequiredArgsConstructor
@RequestMapping(SUBJECT_FROM_CAREER_URI)
public class SubjectPerCareerController implements SubjectPerCareerApi {

    private final SubjectPerCareerService service;

    private final SubjectPerCareerControllerMapper mapper;

    @Override
    @GetMapping("/{career_id}/{subject_id}")
    public ResponseEntity<SubjectFromCareerResponse> getSubjectFromCareer(@PathVariable Long career_id,
                                                                          @PathVariable Long subject_id) {

        SubjectPerCareerId id = new SubjectPerCareerId();
        id.setIdCareer(career_id);
        id.setIdSubject(subject_id);

        SubjectFromCareer subjectFromCareer = service.getSubjectFromCareer(id);

        SubjectFromCareerResponse response = mapper.subjectFromCareerToSubjectFromCareerResponse(subjectFromCareer);

        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{career_id}")
    public ResponseEntity<SubjectFromCareerListResponse> getSubjectsFromACareer(@PathVariable Long career_id,
                                                                        @RequestParam Optional<Integer> page,
                                                                        @RequestParam Optional<Integer> size) {
        final int pageNumber = page.filter(p -> p > 0).orElse(ApiConstants.DEFAULT_PAGE);
        final int pageSize = page.filter(s -> s > 0).orElse(ApiConstants.DEFAULT_PAGE_SIZE);

        SubjectFromCareerList list = service.getSubjectsFromCareer(career_id, PageRequest.of(pageNumber, pageSize));

        SubjectFromCareerListResponse response = createResponse(list);

        return ResponseEntity.ok().body(response);

    }

    @Override
    @PostMapping("/{career_id}/{subject_id}")
    public ResponseEntity<SubjectFromCareerResponse> addSubjectToCareer(@PathVariable Long career_id,
                                                                        @PathVariable Long subject_id,
                                                                        @RequestBody AddSubjectToCareerRequest request) {

        SubjectFromCareer subjectFromCareer = mapper.addSubjectToCareerToSubjectPerCareer(request);
        SubjectPerCareerId id = new SubjectPerCareerId(career_id, subject_id);
        subjectFromCareer.setId(id);
        service.addSubjectToCareer(subjectFromCareer);

        URI location = ServletUriComponentsBuilder.fromCurrentRe quest()
                .build().toUri();

        return ResponseEntity.created(location).build();
    }

    private SubjectFromCareerListResponse createResponse(SubjectFromCareerList list) {


        SubjectFromCareerListResponse response;
        {
            response = new SubjectFromCareerListResponse();
            List<SubjectFromCareerResponse> content = mapper.subjectFromCareerListToSubjectListResponse(list.getContent());
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
