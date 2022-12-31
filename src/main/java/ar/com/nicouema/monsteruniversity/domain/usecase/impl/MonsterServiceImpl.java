package ar.com.nicouema.monsteruniversity.domain.usecase.impl;

import ar.com.nicouema.monsteruniversity.common.exception.NotFoundException;
import ar.com.nicouema.monsteruniversity.domain.model.Monster;
import ar.com.nicouema.monsteruniversity.domain.model.list.MonsterList;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import ar.com.nicouema.monsteruniversity.domain.repository.MonsterRepository;
import ar.com.nicouema.monsteruniversity.domain.usecase.MonsterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonsterServiceImpl implements MonsterService {

    private final MonsterRepository monsterRepository;


    @Override
    public MonsterId createMonster(Monster monster) {
        return monsterRepository.save(monster).getId();
    }

    @Override
    public Monster getMonsterById(MonsterId monsterId) {
        return monsterRepository.findById(monsterId).orElseThrow(() -> new NotFoundException(monsterId.getId()));
    }

    @Override
    public MonsterList getAllMonster(PageRequest pageRequest) {
        Page<Monster> page = monsterRepository.findAll(pageRequest);
        return new MonsterList(page.getContent(), pageRequest, page.getTotalElements());
    }
}
