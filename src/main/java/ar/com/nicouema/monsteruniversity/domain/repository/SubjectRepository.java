package ar.com.nicouema.monsteruniversity.domain.repository;

import ar.com.nicouema.monsteruniversity.domain.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long>, CrudRepository<Subject, Long> {
}
