package ar.com.nicouema.monsteruniversity.domain.model.list;

import ar.com.nicouema.monsteruniversity.domain.model.SubjectFromCareer;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class SubjectFromCareerList extends PageImpl<SubjectFromCareer> {

    public SubjectFromCareerList(List<SubjectFromCareer> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

}
