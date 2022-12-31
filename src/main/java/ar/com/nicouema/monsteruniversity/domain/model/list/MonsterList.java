package ar.com.nicouema.monsteruniversity.domain.model.list;

import ar.com.nicouema.monsteruniversity.domain.model.Monster;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MonsterList extends PageImpl<Monster> {
    public MonsterList(List<Monster> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
}
