package ar.com.nicouema.monsteruniversity.domain.repository;

import ar.com.nicouema.monsteruniversity.domain.model.Monster;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MonsterRepository extends PagingAndSortingRepository<Monster, MonsterId>,
        CrudRepository<Monster, MonsterId> {
}
