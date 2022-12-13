package ar.com.nicouema.monsteruniversity.domain.model.audit;

public interface Auditable {
    Audit getAudit();
    void setAudit(Audit audit);
}
