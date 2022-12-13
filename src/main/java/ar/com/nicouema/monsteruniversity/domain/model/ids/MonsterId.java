package ar.com.nicouema.monsteruniversity.domain.model.ids;

import ar.com.nicouema.monsteruniversity.domain.model.IdType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MonsterId implements Serializable {

    @Column(name = "id_monster")
    private Long id;

    @Column(name = "id_type")
    private Long idType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonsterId monsterId1 = (MonsterId) o;
        return id.equals(monsterId1.id) && idType.equals(monsterId1.idType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idType);
    }
}
