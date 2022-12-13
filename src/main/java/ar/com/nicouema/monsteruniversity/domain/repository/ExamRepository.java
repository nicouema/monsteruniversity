package ar.com.nicouema.monsteruniversity.domain.repository;

import ar.com.nicouema.monsteruniversity.domain.model.Exam;
import ar.com.nicouema.monsteruniversity.domain.model.ids.ExamId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExamRepository extends PagingAndSortingRepository<Exam, ExamId>, CrudRepository<Exam, ExamId> {
}
