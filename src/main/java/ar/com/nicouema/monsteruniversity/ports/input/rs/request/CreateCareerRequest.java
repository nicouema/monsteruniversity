package ar.com.nicouema.monsteruniversity.ports.input.rs.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCareerRequest {

    @NotBlank
    private String degree;
}
