package ar.com.nicouema.monsteruniversity.ports.input.rs.api;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.function.Function;

public interface ApiConstants {

    String CAREER_URI="/careers";

    String MONSTER_URI="/monsters";

    String INSCRIPTION_URI="/inscriptions";

    String SUBJECT_FROM_CAREER_URI="/subjects-from-career";

    String SUBJECT_URI="/subjects";

    Function<Integer, String> uriByPageAsString = (page) ->
            ServletUriComponentsBuilder.fromCurrentRequest()
                    .replaceQueryParam("page", page).toUriString();

    int DEFAULT_PAGE = 0;
    int DEFAULT_PAGE_SIZE = 10;

}
