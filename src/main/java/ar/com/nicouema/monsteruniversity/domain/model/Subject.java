package ar.com.nicouema.monsteruniversity.domain.model;

import ar.com.nicouema.monsteruniversity.domain.model.audit.Audit;
import ar.com.nicouema.monsteruniversity.domain.model.audit.AuditListener;
import ar.com.nicouema.monsteruniversity.domain.model.audit.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Objects;
import java.util.Set;

@Entity(name = "subject")
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE subject set is_active=false, deleted_at=CURRENT_TIMESTAMP() WHERE id_subject=?")
@Where(clause = "is_active=true")
@EntityListeners(AuditListener.class)
public class Subject implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Long id;

    private String name;

    @Embedded
    private Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id.equals(subject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
