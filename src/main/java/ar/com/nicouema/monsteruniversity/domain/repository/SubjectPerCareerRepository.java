package ar.com.nicouema.monsteruniversity.domain.repository;

import ar.com.nicouema.monsteruniversity.domain.model.SubjectFromCareer;
import ar.com.nicouema.monsteruniversity.domain.model.ids.SubjectPerCareerId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectPerCareerRepository extends CrudRepository<SubjectFromCareer, SubjectPerCareerId>,
        PagingAndSortingRepository<SubjectFromCareer, SubjectPerCareerId> {
}
