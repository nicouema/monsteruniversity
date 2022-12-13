package ar.com.nicouema.monsteruniversity.ports.input.rs.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Data
@Builder
@Getter
@Setter
public class MonsterResponse {

    @JsonProperty("id_type")
    private String idType;

    @JsonProperty(value = "id_monster")
    private Long idMonster;

    private String name;

    private String lastname;

    @JsonIgnore
    private LocalDate birthdate;


    private Integer age;

    @JsonProperty("street_name")
    private String streetName;

    @JsonProperty("street_number")
    private Integer streetNumber;

    @JsonProperty("city_name")
    private String city;

    public MonsterResponse() {
        this.age = calculateAge();
    }

    public MonsterResponse(String idType, Long idMonster, String name, String lastname, LocalDate birthdate,
                           Integer age, String streetName, Integer streetNumber, String city) {
        this.idType = idType;
        this.idMonster = idMonster;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.age = calculateAge();
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
    }

    public Integer calculateAge() {
        LocalDate currentDate = LocalDate.now();
        assert this.birthdate != null;
        return Period.between(this.birthdate, currentDate).getYears();
    }
}
