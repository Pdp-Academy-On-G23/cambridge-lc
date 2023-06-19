package uz.pdp.cambridgelc.entity.link;

import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "links")
public class Link extends BaseEntity {
    private String link;
}
