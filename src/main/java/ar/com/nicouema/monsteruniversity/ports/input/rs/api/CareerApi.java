package ar.com.nicouema.monsteruniversity.ports.input.rs.api;

import ar.com.nicouema.monsteruniversity.ports.input.rs.request.CreateCareerRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.CareerListResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CareerApi {

    ResponseEntity<Void> createCareer(@Valid CreateCareerRequest careerRequest);

    ResponseEntity<CareerListResponse> getAllCareers(Optional<Integer> page, Optional<Integer> size);

}
