package uz.pdp.cambridgelc.entity.attachment;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "attachment_content")
public class AttachmentContent extends BaseEntity {
    private byte[] mainContent;

    @OneToOne
    private AttachmentEntity attachment;
}
