package ar.com.nicouema.monsteruniversity.domain.model;

import ar.com.nicouema.monsteruniversity.domain.model.ids.StudiedId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "studied")
@NoArgsConstructor
@Getter
@Setter
public class Studied {

    @EmbeddedId
    private StudiedId studiedId;

    @ManyToOne
    @MapsId("careerId")
    @JoinColumn(name = "id_career")
    private Career career;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToOne
    @MapsId("monsterId")
    @JoinColumns({@JoinColumn(name = "id_monster"), @JoinColumn(name = "id_type")})
    private Monster monster;

    @Column(name = "inscription_date")
    private LocalDate inscriptionDate;

    private String state;

    @Column(name = "date_state")
    private LocalDate dateState;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studied studied = (Studied) o;
        return studiedId.equals(studied.studiedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studiedId);
    }
}
