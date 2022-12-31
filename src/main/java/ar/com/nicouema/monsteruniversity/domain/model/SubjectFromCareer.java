package ar.com.nicouema.monsteruniversity.domain.model;

import ar.com.nicouema.monsteruniversity.domain.model.audit.Audit;
import ar.com.nicouema.monsteruniversity.domain.model.audit.AuditListener;
import ar.com.nicouema.monsteruniversity.domain.model.ids.SubjectPerCareerId;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

@Entity(name = "career_subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE career_subject SET is_active=false, deleted_at=CURRENT_TIMESTAMP WHERE id_career=? " +
        "AND id_subject=?")
@EntityListeners(AuditListener.class)
public class SubjectFromCareer {

    @EmbeddedId
    private SubjectPerCareerId id;

    @ManyToOne
    @MapsId("idSubject")
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToOne
    @MapsId("idCareer")
    @JoinColumn(name = "id_career")
    private Career career;

    private String description;

    private Integer year;

    private Integer quarter;

    private String condition;

    @Embedded
    private Audit audit;

    public void update(SubjectFromCareer subject) {
        if (subject.getSubject() != null) this.setSubject(subject.getSubject());
        if (subject.getCareer() != null) this.setCareer(subject.getCareer());
    }
}
