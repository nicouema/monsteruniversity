package ar.com.nicouema.monsteruniversity.domain.model.list;

import ar.com.nicouema.monsteruniversity.domain.model.Subject;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class SubjectList extends PageImpl<Subject> {
    public SubjectList(List<Subject> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
}
