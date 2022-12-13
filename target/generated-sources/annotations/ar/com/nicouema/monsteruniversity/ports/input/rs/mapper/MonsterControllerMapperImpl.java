package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;

import ar.com.nicouema.monsteruniversity.domain.model.City;
import ar.com.nicouema.monsteruniversity.domain.model.IdType;
import ar.com.nicouema.monsteruniversity.domain.model.Monster;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.CreateMonsterRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.MonsterResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class MonsterControllerMapperImpl implements MonsterControllerMapper {

    @Override
    public Monster monsterCreateRequestToMonster(CreateMonsterRequest createMonsterRequest) {
        if ( createMonsterRequest == null ) {
            return null;
        }

        Monster monster = new Monster();

        monster.setId( createMonsterRequestToMonsterId( createMonsterRequest ) );
        monster.setIdType( createMonsterRequestToIdType( createMonsterRequest ) );
        monster.setCity( createMonsterRequestToCity( createMonsterRequest ) );
        monster.setName( createMonsterRequest.getName() );
        monster.setLastname( createMonsterRequest.getLastname() );
        monster.setBirthdate( createMonsterRequest.getBirthdate() );
        monster.setStreetName( createMonsterRequest.getStreetName() );
        monster.setStreetNumber( createMonsterRequest.getStreetNumber() );

        return monster;
    }

    @Override
    public MonsterResponse monsterToMonsterResponse(Monster monster) {
        if ( monster == null ) {
            return null;
        }

        MonsterResponse.MonsterResponseBuilder monsterResponse = MonsterResponse.builder();

        monsterResponse.idType( monsterIdTypeName( monster ) );
        monsterResponse.idMonster( monsterIdId( monster ) );
        monsterResponse.city( monsterCityName( monster ) );
        monsterResponse.name( monster.getName() );
        monsterResponse.lastname( monster.getLastname() );
        monsterResponse.birthdate( monster.getBirthdate() );
        monsterResponse.streetName( monster.getStreetName() );
        monsterResponse.streetNumber( monster.getStreetNumber() );

        return monsterResponse.build();
    }

    @Override
    public List<MonsterResponse> monsterListToMonsterListResponse(List<Monster> content) {
        if ( content == null ) {
            return null;
        }

        List<MonsterResponse> list = new ArrayList<MonsterResponse>( content.size() );
        for ( Monster monster : content ) {
            list.add( monsterToMonsterResponse( monster ) );
        }

        return list;
    }

    protected MonsterId createMonsterRequestToMonsterId(CreateMonsterRequest createMonsterRequest) {
        if ( createMonsterRequest == null ) {
            return null;
        }

        MonsterId monsterId = new MonsterId();

        monsterId.setId( createMonsterRequest.getIdMonster() );

        return monsterId;
    }

    protected IdType createMonsterRequestToIdType(CreateMonsterRequest createMonsterRequest) {
        if ( createMonsterRequest == null ) {
            return null;
        }

        IdType idType = new IdType();

        idType.setId( createMonsterRequest.getIdType() );

        return idType;
    }

    protected City createMonsterRequestToCity(CreateMonsterRequest createMonsterRequest) {
        if ( createMonsterRequest == null ) {
            return null;
        }

        City city = new City();

        city.setId( createMonsterRequest.getCityId() );

        return city;
    }

    private String monsterIdTypeName(Monster monster) {
        if ( monster == null ) {
            return null;
        }
        IdType idType = monster.getIdType();
        if ( idType == null ) {
            return null;
        }
        String name = idType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long monsterIdId(Monster monster) {
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

    private String monsterCityName(Monster monster) {
        if ( monster == null ) {
            return null;
        }
        City city = monster.getCity();
        if ( city == null ) {
            return null;
        }
        String name = city.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
