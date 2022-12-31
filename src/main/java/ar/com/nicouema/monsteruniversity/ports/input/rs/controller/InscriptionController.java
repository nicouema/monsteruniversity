package ar.com.nicouema.monsteruniversity.ports.input.rs.controller;

import ar.com.nicouema.monsteruniversity.domain.model.Inscription;
import ar.com.nicouema.monsteruniversity.domain.model.list.InscriptionList;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import ar.com.nicouema.monsteruniversity.domain.usecase.InscriptionService;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.InscriptionApi;
import ar.com.nicouema.monsteruniversity.ports.input.rs.mapper.InscriptionControllerMapper;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.InscriptionListResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.InscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.INSCRIPTION_URI;
import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.uriByPageAsString;

@RestController
@RequestMapping(INSCRIPTION_URI)
@RequiredArgsConstructor
public class InscriptionController implements InscriptionApi{

    private final InscriptionService service;
    private final InscriptionControllerMapper mapper;

    @Override
    @PostMapping("/{id_career}/{id_type}/{id_monster}")
    public ResponseEntity<InscriptionResponse> subscribeMonster(
            @PathVariable Long id_career,
            @PathVariable Long id_type,
            @PathVariable Long id_monster
    ) {

        MonsterId monsterId = new MonsterId(id_monster, id_type);

        Inscription inscription = service.subscribeMonsterToCareer(id_career, monsterId);

        InscriptionResponse response = mapper.inscriptionToInscriptionResponse(inscription);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .build()
                .toUri();

        return ResponseEntity.created(location).body(response);
    }



    @Override
    @DeleteMapping("/{id_career}/{id_type}/{id_monster}")
    public ResponseEntity<Void> unsubscribeMonster(@PathVariable Long id_career,
                                                   @PathVariable Long id_type,
                                                   @PathVariable Long id_monster) {

        MonsterId monsterId = new MonsterId(id_monster, id_type);

        service.unsubscribeMonsterFromCareer(id_career, monsterId);

        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/{id_career}")
    public ResponseEntity<InscriptionListResponse> getInscriptionsByCareerId(@PathVariable Long id_career,
                                                                             @RequestParam Optional<Integer> page,
                                                                             @RequestParam Optional<Integer> size) {

        final int pageNumber = page.filter(p -> p > 0).orElse(ApiConstants.DEFAULT_PAGE);
        final int pageSize = page.filter(s -> s > 0).orElse(ApiConstants.DEFAULT_PAGE_SIZE);

        InscriptionList list = service.getInscriptionsByCareerId(id_career, PageRequest.of(pageNumber, pageSize));
        InscriptionListResponse response = createResponse(list);
        return ResponseEntity.ok().body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<InscriptionListResponse> getInscriptionsByMonsterLastname(@RequestParam String lastname,
                                                                                    @RequestParam Optional<Integer> page,
                                                                                    @RequestParam Optional<Integer> size)
    {
        final int pageNumber = page.filter(p -> p > 0).orElse(ApiConstants.DEFAULT_PAGE);
        final int pageSize = page.filter(s -> s > 0).orElse(ApiConstants.DEFAULT_PAGE_SIZE);

        InscriptionList list = service.getInscriptionsByMonsterLastname(lastname, PageRequest.of(pageNumber, pageSize));
        InscriptionListResponse response = createResponse(list);
        return ResponseEntity.ok().body(response);
    }

    private InscriptionListResponse createResponse(InscriptionList list) {

        InscriptionListResponse response;
        {
            response = new InscriptionListResponse();
            List<InscriptionResponse> content = mapper.inscriptionListToInscriptionListResponse(list.getContent());
            response.setContent(content);

            final int nextPage = list.getPageable().next().getPageNumber();
            response.setNextUri(uriByPageAsString.apply(nextPage));

            final int previousPage = list.getPageable().previousOrFirst().getPageNumber();
            response.setPreviousUri(uriByPageAsString.apply(previousPage));

            response.setTotalElements(list.getTotalElements());
            response.setTotalPages(list.getTotalPages());
        }
        return response;
    }
}
