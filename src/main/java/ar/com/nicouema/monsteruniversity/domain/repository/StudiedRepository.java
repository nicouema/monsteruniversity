package ar.com.nicouema.monsteruniversity.domain.repository;

import ar.com.nicouema.monsteruniversity.domain.model.Studied;
import ar.com.nicouema.monsteruniversity.domain.model.ids.StudiedId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudiedRepository extends PagingAndSortingRepository<Studied, StudiedId>,
        CrudRepository<Studied, StudiedId> {
}
