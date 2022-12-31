package ar.com.nicouema.monsteruniversity.domain.usecase;

import ar.com.nicouema.monsteruniversity.domain.model.Monster;
import ar.com.nicouema.monsteruniversity.domain.model.list.MonsterList;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import org.springframework.data.domain.PageRequest;

public interface MonsterService {

    MonsterId createMonster(Monster monster);

    Monster getMonsterById(MonsterId monsterId);

    MonsterList getAllMonster(PageRequest pageRequest);
}
