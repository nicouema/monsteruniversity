package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;

import ar.com.nicouema.monsteruniversity.domain.model.Inscription;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.InscriptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface InscriptionControllerMapper {

    @Mapping(target = "monsterId", source = "monster.id.id")
    @Mapping(target = "nameIdType", source = "monster.id.idType")
    @Mapping(target = "careerDegree", source = "career.degree")
    InscriptionResponse inscriptionToInscriptionResponse(Inscription inscription);

    List<InscriptionResponse> inscriptionListToInscriptionListResponse(List<Inscription> content);
}
