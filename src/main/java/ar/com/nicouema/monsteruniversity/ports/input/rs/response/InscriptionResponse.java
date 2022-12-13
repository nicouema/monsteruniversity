package ar.com.nicouema.monsteruniversity.ports.input.rs.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionResponse {

    @JsonProperty("name_id_type")
    private String nameIdType;

    @JsonProperty("monster_id")
    private Long monsterId;

    @JsonProperty("career_degree")
    private String careerDegree;

    private LocalDate date;

}
