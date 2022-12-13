package ar.com.nicouema.monsteruniversity.ports.input.rs.api;

import ar.com.nicouema.monsteruniversity.ports.input.rs.request.CreateMonsterRequest;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.MonsterListResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.MonsterResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface MonsterApi {

    ResponseEntity<MonsterResponse> createMonster(@Valid CreateMonsterRequest createMonsterRequest);

    ResponseEntity<MonsterResponse> getMonsterById(Long idType, Long idMonster);

    ResponseEntity<MonsterListResponse> getAllMonster(Optional<Integer> page, Optional<Integer> size);
}
