package ar.com.nicouema.monsteruniversity.domain.model.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InscriptionId implements Serializable {

    @Column(name = "id_career")
    private Long careerId;

//    @Column(name = "id_monster")
    private MonsterId monsterId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionId that = (InscriptionId) o;
        return careerId.equals(that.careerId) && monsterId.equals(that.monsterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(careerId, monsterId);
    }
}
