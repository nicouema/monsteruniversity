package ar.com.nicouema.monsteruniversity.domain.usecase.impl;

import ar.com.nicouema.monsteruniversity.common.exception.NotFoundException;
import ar.com.nicouema.monsteruniversity.domain.model.Career;
import ar.com.nicouema.monsteruniversity.domain.model.Inscription;
import ar.com.nicouema.monsteruniversity.domain.model.list.InscriptionList;
import ar.com.nicouema.monsteruniversity.domain.model.Monster;
import ar.com.nicouema.monsteruniversity.domain.model.ids.InscriptionId;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import ar.com.nicouema.monsteruniversity.domain.repository.CareerRepository;
import ar.com.nicouema.monsteruniversity.domain.repository.InscriptionRepository;
import ar.com.nicouema.monsteruniversity.domain.repository.MonsterRepository;
import ar.com.nicouema.monsteruniversity.domain.usecase.InscriptionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    private final MonsterRepository monsterRepository;

    private final CareerRepository careerRepository;

    @Override
    @Transactional
    public Inscription subscribeMonsterToCareer(Long careerId, MonsterId monsterId) {

        Career career = careerRepository.findById(careerId)
                .orElseThrow(() -> new NotFoundException(careerId));
        Monster monster = monsterRepository.findById(monsterId)
                .orElseThrow(() -> new NotFoundException(monsterId));

        Inscription inscription = new Inscription();

        InscriptionId id = new InscriptionId();
        id.setCareerId(careerId);
        id.setMonsterId(monsterId);
        inscription.setId(id);

        inscription.setCareer(career);
        inscription.setMonster(monster);
        inscription.setDate(LocalDate.now());

        inscriptionRepository.save(inscription);

        return inscription;

    }

    @Override
    @Transactional
    public void unsubscribeMonsterFromCareer(Long careerId, MonsterId monsterId) {

        careerRepository.findById(careerId)
                .orElseThrow(() -> new NotFoundException(careerId));
        monsterRepository.findById(monsterId)
                .orElseThrow(() -> new NotFoundException(monsterId));

        InscriptionId id = new InscriptionId();
        id.setCareerId(careerId);
        id.setMonsterId(monsterId);

        inscriptionRepository.deleteById(id);
    }

    @Override
    public InscriptionList getInscriptionsByCareerId(Long careerId, PageRequest pageRequest) {
        Page<Inscription> page = inscriptionRepository.getAllByCareer_Id(careerId, pageRequest);
        return new InscriptionList(page.getContent(), pageRequest, page.getTotalElements());
    }

    @Override
    public InscriptionList getInscriptionsByMonsterLastname(String lastname, PageRequest pageRequest) {
        Page<Inscription> page = inscriptionRepository
                .getAllByMonster_LastnameContainingIgnoreCase(lastname, pageRequest);
        return new InscriptionList(page.getContent(), pageRequest, page.getTotalElements());
    }
}
