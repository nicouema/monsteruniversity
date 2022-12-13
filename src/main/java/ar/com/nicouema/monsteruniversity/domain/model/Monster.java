package ar.com.nicouema.monsteruniversity.domain.model;

import ar.com.nicouema.monsteruniversity.domain.model.audit.Audit;
import ar.com.nicouema.monsteruniversity.domain.model.audit.AuditListener;
import ar.com.nicouema.monsteruniversity.domain.model.audit.Auditable;
import ar.com.nicouema.monsteruniversity.domain.model.ids.MonsterId;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "monster")
@Getter
@Setter
@NoArgsConstructor
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE monster SET is_active=false, deleted_at=CURRENT_TIMESTAMP() WHERE id_monster=? AND id_type=?")
@EntityListeners(AuditListener.class)
public class Monster implements Auditable {

    @EmbeddedId
    private MonsterId id;

    @ManyToOne(targetEntity = IdType.class)
    @MapsId("idType")
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    private IdType idType;

    private String name;

    private String lastname;

    private LocalDate birthdate;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_number")
    private Integer streetNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @Embedded
    private Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return id.equals(monster.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
