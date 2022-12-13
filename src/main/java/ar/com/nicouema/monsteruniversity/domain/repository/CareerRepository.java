package ar.com.nicouema.monsteruniversity.domain.repository;


import ar.com.nicouema.monsteruniversity.domain.model.Career;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CareerRepository extends PagingAndSortingRepository<Career, Long>, CrudRepository<Career, Long> {
}
