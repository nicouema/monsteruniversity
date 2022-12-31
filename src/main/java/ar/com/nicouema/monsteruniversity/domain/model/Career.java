package ar.com.nicouema.monsteruniversity.domain.model;

import ar.com.nicouema.monsteruniversity.domain.model.audit.Audit;
import ar.com.nicouema.monsteruniversity.domain.model.audit.AuditListener;
import ar.com.nicouema.monsteruniversity.domain.model.audit.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Objects;
import java.util.Set;

@Entity(name = "career")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditListener.class)
@SQLDelete(sql = "UPDATE subject SET is_active=false, deleted_at=CURRENT_TIMESTAMP() WHERE id_career=?")
@Where(clause = "is_active=true")
public class Career implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_career")
    private Long id;

    private String degree;


    @Embedded
    private Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Career career = (Career) o;
        return id.equals(career.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
