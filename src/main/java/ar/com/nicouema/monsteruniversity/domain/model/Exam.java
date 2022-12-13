package ar.com.nicouema.monsteruniversity.domain.model;

import ar.com.nicouema.monsteruniversity.domain.model.audit.AuditListener;
import ar.com.nicouema.monsteruniversity.domain.model.ids.ExamId;
import jakarta.persistence.Column;
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

import java.util.Objects;

@Entity(name = "exam")
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE exam SET is_active=false, deleted_at=CURRENT_TIMESTAMP " +
        "WHERE id_career=? AND id_subject=? AND id_type=? AND id_monster=? AND date=?" )
@EntityListeners(AuditListener.class)
public class Exam {

    @EmbeddedId
    private ExamId examId;

    @ManyToOne
    @MapsId("careerId")
    @JoinColumn(name = "id_career")
    private Career career;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToOne
    @MapsId("monsterId")
    @JoinColumns({@JoinColumn(name = "id_monster"), @JoinColumn(name = "id_type")})
    private Monster monster;

    @Column(name = "is_absent")
    private boolean absent;

    private Integer mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return examId.equals(exam.examId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId);
    }
}
