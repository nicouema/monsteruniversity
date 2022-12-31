package ar.com.nicouema.monsteruniversity.domain.usecase;

import ar.com.nicouema.monsteruniversity.domain.model.Inscription;
import ar.com.nicouema.monsteruniversity.domain.model.list.InscriptionList;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import org.springframework.data.domain.PageRequest;

public interface InscriptionService {

    Inscription subscribeMonsterToCareer(Long careerId, MonsterId monsterId);

    void unsubscribeMonsterFromCareer(Long careerId, MonsterId monsterId);

    InscriptionList getInscriptionsByCareerId(Long careerId, PageRequest pageRequest);

    InscriptionList getInscriptionsByMonsterLastname(String lastname, PageRequest pageRequest);


}
