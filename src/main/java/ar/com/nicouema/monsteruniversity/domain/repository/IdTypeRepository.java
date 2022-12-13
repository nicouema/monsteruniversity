package ar.com.nicouema.monsteruniversity.domain.repository;

import ar.com.nicouema.monsteruniversity.domain.model.IdType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IdTypeRepository extends PagingAndSortingRepository<IdType, Long>, CrudRepository<IdType, Long> {
}
