package uz.pdp.cambridgelc.entity.attachment;

import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "attachment")
public class AttachmentEntity extends BaseEntity {
    private String name;
    private Long size;
    private String contentType;
}
