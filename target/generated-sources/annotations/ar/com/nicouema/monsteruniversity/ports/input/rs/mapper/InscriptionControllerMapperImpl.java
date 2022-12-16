package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;

import ar.com.nicouema.monsteruniversity.domain.model.Career;
import ar.com.nicouema.monsteruniversity.domain.model.Inscription;
import ar.com.nicouema.monsteruniversity.domain.model.Monster;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.InscriptionResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class InscriptionControllerMapperImpl implements InscriptionControllerMapper {

    @Override
    public InscriptionResponse inscriptionToInscriptionResponse(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }

        InscriptionResponse inscriptionResponse = new InscriptionResponse();

        inscriptionResponse.setMonsterId( inscriptionMonsterIdId( inscription ) );
        Long idType = inscriptionMonsterIdIdType( inscription );
        if ( idType != null ) {
            inscriptionResponse.setNameIdType( String.valueOf( idType ) );
        }
        inscriptionResponse.setCareerDegree( inscriptionCareerDegree( inscription ) );
        inscriptionResponse.setDate( inscription.getDate() );

        return inscriptionResponse;
    }

    @Override
    public List<InscriptionResponse> inscriptionListToInscriptionListResponse(List<Inscription> content) {
        if ( content == null ) {
            return null;
        }

        List<InscriptionResponse> list = new ArrayList<InscriptionResponse>( content.size() );
        for ( Inscription inscription : content ) {
            list.add( inscriptionToInscriptionResponse( inscription ) );
        }

        return list;
    }

    private Long inscriptionMonsterIdId(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }
        Monster monster = inscription.getMonster();
        if ( monster == null ) {
            return null;
        }
        MonsterId id = monster.getId();
        if ( id == null ) {
            return null;
        }
        Long id1 = id.getId();
        if ( id1 == null ) {
            return null;
        }
        return id1;
    }

    private Long inscriptionMonsterIdIdType(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }
        Monster monster = inscription.getMonster();
        if ( monster == null ) {
            return null;
        }
        MonsterId id = monster.getId();
        if ( id == null ) {
            return null;
        }
        Long idType = id.getIdType();
        if ( idType == null ) {
            return null;
        }
        return idType;
    }

    private String inscriptionCareerDegree(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }
        Career career = inscription.getCareer();
        if ( career == null ) {
            return null;
        }
        String degree = career.getDegree();
        if ( degree == null ) {
            return null;
        }
        return degree;
    }
}
