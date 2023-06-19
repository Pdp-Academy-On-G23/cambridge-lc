package uz.pdp.cambridgelc.entity.branch;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;
import uz.pdp.cambridgelc.entity.attachment.AttachmentEntity;
import uz.pdp.cambridgelc.entity.icon.IconEntity;
import uz.pdp.cambridgelc.entity.link.Link;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "branches")
public class BranchEntity extends BaseEntity {
    private String name;
    private String address;

    @OneToMany
    private Set<Link> links;

    @OneToOne
    private AttachmentEntity attachment;

    @OneToOne
    private IconEntity icon;
}
