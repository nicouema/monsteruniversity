package ar.com.nicouema.monsteruniversity.ports.input.rs.api;

import ar.com.nicouema.monsteruniversity.ports.input.rs.response.InscriptionListResponse;
import ar.com.nicouema.monsteruniversity.ports.input.rs.response.InscriptionResponse;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface InscriptionApi {

    ResponseEntity<InscriptionResponse> subscribeMonster(Long id_career, Long id_type, Long id_monster);

    ResponseEntity<Void> unsubscribeMonster(Long id_career, Long id_type, Long id_monster);

    ResponseEntity<InscriptionListResponse> getInscriptionsByCareerId(Long idCareer, Optional<Integer> page, Optional<Integer> size);

    ResponseEntity<InscriptionListResponse> getInscriptionsByMonsterLastname(String lastname, Optional<Integer> page, Optional<Integer> size);

}
