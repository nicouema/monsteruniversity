package ar.com.nicouema.monsteruniversity.domain.model;

import ar.com.nicouema.monsteruniversity.domain.model.audit.Audit;
import ar.com.nicouema.monsteruniversity.domain.model.audit.AuditListener;
import ar.com.nicouema.monsteruniversity.domain.model.audit.Auditable;
import ar.com.nicouema.monsteruniversity.domain.model.ids.InscriptionId;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "inscription_career")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditListener.class)
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE inscription_career SET is_active=false, deleted_at=current_timestamp " +
        "WHERE id_career=? ANd id_monster=? AND id_type=?")
public class Inscription implements Auditable {

    @EmbeddedId
    private InscriptionId id;

    @ManyToOne
    @MapsId("careerId")
    @JoinColumn(name = "id_career")
    private Career career;

    @ManyToOne
    @MapsId("monsterId")
    @JoinColumns({@JoinColumn(name = "id_monster"), @JoinColumn(name = "id_type")})
    private Monster monster;

    @Embedded
    private Audit audit;

    @Column(name = "inscription_date")
    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscription that = (Inscription) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
