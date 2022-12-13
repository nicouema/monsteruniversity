package ar.com.nicouema.monsteruniversity.domain.model;

import ar.com.nicouema.monsteruniversity.domain.model.audit.Audit;
import ar.com.nicouema.monsteruniversity.domain.model.audit.AuditListener;
import ar.com.nicouema.monsteruniversity.domain.model.audit.Auditable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity(name = "id_type")
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE id_type SET is_active=false, deleted_at=CURRENT_TIMESTAMP() WHERE id_type=?")
@EntityListeners(AuditListener.class)
public class IdType implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type")
    private Long id;

    private String name;

    @Embedded
    private Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdType idType1 = (IdType) o;
        return Objects.equals(id, idType1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
