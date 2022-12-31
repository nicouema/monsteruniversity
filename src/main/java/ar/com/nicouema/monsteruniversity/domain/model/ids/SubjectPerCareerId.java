package ar.com.nicouema.monsteruniversity.domain.model.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectPerCareerId implements Serializable {

    @Column(name = "id_career")
    private Long idCareer;

    @Column(name = "id_subject")
    private Long idSubject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectPerCareerId that = (SubjectPerCareerId) o;
        return idCareer.equals(that.idCareer) && idSubject.equals(that.idSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCareer, idSubject);
    }
}
