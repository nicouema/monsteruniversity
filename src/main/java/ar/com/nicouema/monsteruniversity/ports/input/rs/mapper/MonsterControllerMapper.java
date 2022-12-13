package ar.com.nicouema.monsteruniversity.ports.input.rs.mapper;


import ar.com.nicouema.monsteruniversity.domain.model.Monster;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.CreateMonsterRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.MonsterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MonsterControllerMapper {

    @Mapping(target = "city", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "id.id", source = "idMonster")
    @Mapping(target = "idType.id", source = "idType")
    @Mapping(target = "city.id", source = "cityId")
    @Mapping(target = "audit", ignore = true)
    Monster monsterCreateRequestToMonster(CreateMonsterRequest createMonsterRequest);

    @Mapping(target = "age", ignore = true)
    @Mapping(target = "idType", source = "idType.name")
    @Mapping(target = "idMonster", source = "id.id")
    @Mapping(target = "city", source = "city.name")
    MonsterResponse monsterToMonsterResponse(Monster monster);

    List<MonsterResponse> monsterListToMonsterListResponse(List<Monster> content);
}
