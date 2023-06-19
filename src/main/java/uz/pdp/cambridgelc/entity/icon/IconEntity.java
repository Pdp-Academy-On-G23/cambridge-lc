package uz.pdp.cambridgelc.entity.icon;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;
import uz.pdp.cambridgelc.entity.attachment.AttachmentEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "icons")
public class IconEntity extends BaseEntity {

    @OneToOne
    private AttachmentEntity attachment;
}
