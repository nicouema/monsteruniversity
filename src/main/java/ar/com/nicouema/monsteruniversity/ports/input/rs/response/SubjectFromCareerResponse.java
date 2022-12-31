package ar.com.nicouema.monsteruniversity.ports.input.rs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectFromCareerResponse {

    @JsonProperty("career_id")
    private Long careerId;

    @JsonProperty("subject_id")
    private Long subjectId;

    private String description;

    private Integer year;

    private Integer quarter;

    private String condition;

}
