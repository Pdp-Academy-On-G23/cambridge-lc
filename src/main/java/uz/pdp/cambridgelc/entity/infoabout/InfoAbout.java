package uz.pdp.cambridgelc.entity.infoabout;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;
import uz.pdp.cambridgelc.entity.attachment.AttachmentEntity;
import uz.pdp.cambridgelc.entity.link.Link;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "thedata")
public class InfoAbout extends BaseEntity {
    private String title;
    private String description;

    @OneToOne
    private Link link;

    @OneToOne
    private AttachmentEntity attachment;
}
