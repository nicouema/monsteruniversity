package ar.com.nicouema.monsteruniversity.ports.input.rs.controller;

import ar.com.nicouema.monsteruniversity.domain.model.Monster;
import ar.com.nicouema.monsteruniversity.domain.model.MonsterList;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import ar.com.nicouema.monsteruniversity.domain.usecase.MonsterService;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants;
import ar.com.nicouema.monsteruniversity.ports.input.rs.api.MonsterApi;
import ar.com.nicouema.monsteruniversity.ports.input.rs.mapper.MonsterControllerMapper;
import ar.com.nicouema.monsteruniversity.ports.input.rs.request.CreateMonsterRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.MonsterListResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.MonsterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.DEFAULT_PAGE;
import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.DEFAULT_PAGE_SIZE;
import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.MONSTER_URI;
import static ar.com.nicouema.monsteruniversity.ports.input.rs.api.ApiConstants.uriByPageAsString;

@RestController
@RequestMapping(MONSTER_URI)
@RequiredArgsConstructor
public class MonsterController implements MonsterApi {

    private final MonsterService service;
    private final MonsterControllerMapper mapper;

    @Override
    @PostMapping
    public ResponseEntity<MonsterResponse> createMonster(@RequestBody CreateMonsterRequest createMonsterRequest) {
        Monster monster = mapper.monsterCreateRequestToMonster(createMonsterRequest);
        MonsterId id = service.createMonster(monster);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @Override
    @GetMapping("/{idType}/{id}")
    public ResponseEntity<MonsterResponse> getMonsterById(@PathVariable Long idType,
                                                          @PathVariable Long id) {
        MonsterId monsterId = new MonsterId();
        monsterId.setIdType(idType);
        monsterId.setId(id);

        Monster monster = service.getMonsterById(monsterId);
        MonsterResponse response = mapper.monsterToMonsterResponse(monster);

        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<MonsterListResponse> getAllMonster(@RequestParam Optional<Integer> page,
                                                             @RequestParam Optional<Integer> size) {

        final int pageNumber = page.filter(p -> p > 0).orElse(ApiConstants.DEFAULT_PAGE);
        final int pageSize = page.filter(s -> s > 0).orElse(ApiConstants.DEFAULT_PAGE_SIZE);

        MonsterList list = service.getAllMonster(PageRequest.of(pageNumber, pageSize));

        MonsterListResponse response;
        {
            response = new MonsterListResponse();
            List<MonsterResponse> content = mapper.monsterListToMonsterListResponse(list.getContent());
            response.setContent(content);

            final int nextPage = list.getPageable().next().getPageNumber();
            response.setNextUri(uriByPageAsString.apply(nextPage));

            final int previousPage = list.getPageable().previousOrFirst().getPageNumber();
            response.setPreviousUri(uriByPageAsString.apply(previousPage));

            response.setTotalElements(list.getTotalElements());
            response.setTotalPages(list.getTotalPages());
        }
        return ResponseEntity.ok().body(response);
    }
}
