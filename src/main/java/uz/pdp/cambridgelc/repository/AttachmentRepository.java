package uz.pdp.cambridgelc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.cambridgelc.entity.attachment.AttachmentEntity;

public interface AttachmentRepository extends JpaRepository<AttachmentEntity, Long> {
}
