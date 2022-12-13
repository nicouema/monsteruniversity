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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "city")
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE city SET is_active=false, deleted_at=CURRENT_TIMESTAMP() WHERE city_id=?")
@EntityListeners(AuditListener.class)
public class City implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Set<Monster> monsters;

    @Embedded
    private Audit audit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City aCity = (City) o;
        return Objects.equals(id, aCity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
