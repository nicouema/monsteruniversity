package ar.com.nicouema.monsteruniversity.domain.repository;

import ar.com.nicouema.monsteruniversity.domain.model.Inscription;
import ar.com.nicouema.monsteruniversity.domain.model.ids.InscriptionId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InscriptionRepository extends PagingAndSortingRepository<Inscription, InscriptionId>,
        CrudRepository<Inscription, InscriptionId> {

    Page<Inscription> getAllByCareer_Id(Long careerId, PageRequest pageRequest);

    Page<Inscription> getAllByMonster_LastnameContainingIgnoreCase(String lastname, PageRequest pageRequest);
}
