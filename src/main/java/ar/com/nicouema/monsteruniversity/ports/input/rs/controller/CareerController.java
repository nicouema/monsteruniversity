package ar.com.nicouema.monsteruniversity.ports.input.rs.controller;

import ar.com.nicouema.monsteruniversity.domain.model.Career;
import ar.com.nicouema.monsteruniversity.domain.model.list.CareerList;
import ar.com.nicouema.monsteruniversity.domain.usecase.CareerService;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.CareerApi;
import ar.com.nicouema.monsteruniversity.ports.input.rs.mapper.CareerControllerMapper;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.CreateCareerRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.CareerListResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.CareerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.CAREER_URI;
import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.uriByPageAsString;

@RestController
@RequestMapping(CAREER_URI)
@RequiredArgsConstructor
public class CareerController implements CareerApi {

    private final CareerService careerService;
    private final CareerControllerMapper mapper;

    @Override
    @PostMapping
    public ResponseEntity<Void> createCareer(@RequestBody CreateCareerRequest careerRequest) {
        Career career = mapper.careerRequestToCareer(careerRequest);

        Long id = careerService.saveCareer(career);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    @GetMapping
    public ResponseEntity<CareerListResponse> getAllCareers(@RequestParam(required = false) Optional<Integer> page,
                                                            @RequestParam(required = false) Optional<Integer> size) {

        final int pageNumber = page.filter(p -> p > 0).orElse(ApiConstants.DEFAULT_PAGE);
        final int pageSize = page.filter(s -> s > 0).orElse(ApiConstants.DEFAULT_PAGE_SIZE);

        CareerList list = careerService.getAllCareers(PageRequest.of(pageNumber, pageSize));

        CareerListResponse response = createResponse(list);
        return ResponseEntity.ok().body(response);

    }

    private CareerListResponse createResponse(CareerList list) {


        CareerListResponse response;
        {
            response = new CareerListResponse();
            List<CareerResponse> content = mapper.careerListToCareerListResponse(list.getContent());
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
