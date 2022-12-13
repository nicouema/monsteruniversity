package ar.com.nicouema.monsteruniversity.domain.model.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExamId implements Serializable {

    @Column(name = "id_career")
    private Long idCareer;

    @Column(name = "id_subject")
    private Long idSubject;

    private MonsterId monsterId;

    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamId examId = (ExamId) o;
        return idCareer.equals(examId.idCareer) && idSubject.equals(examId.idSubject) && monsterId.equals(examId.monsterId) && date.equals(examId.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCareer, idSubject, monsterId, date);
    }
}
