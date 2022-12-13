package ar.com.nicouema.monsteruniversity.ports.input.rs.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMonsterRequest {

    @JsonProperty("id_type")
    private Long idType;

    @JsonProperty("id_monster")
    private Long idMonster;

    private String name;

    private String lastname;

    private LocalDate birthdate;

    @JsonProperty("street_name")
    private String streetName;

    @JsonProperty("street_number")
    private Integer streetNumber;

    @JsonProperty("city_id")
    private Long cityId;

}
