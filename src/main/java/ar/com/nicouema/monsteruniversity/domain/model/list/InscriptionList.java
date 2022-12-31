package ar.com.nicouema.monsteruniversity.domain.model.list;

import ar.com.nicouema.monsteruniversity.domain.model.Inscription;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class InscriptionList extends PageImpl<Inscription> {
    public InscriptionList(List<Inscription> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
}
