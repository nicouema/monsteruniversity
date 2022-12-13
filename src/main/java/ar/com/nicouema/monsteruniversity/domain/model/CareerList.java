package ar.com.nicouema.monsteruniversity.domain.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CareerList extends PageImpl<Career> {

    public CareerList(List<Career> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

}
