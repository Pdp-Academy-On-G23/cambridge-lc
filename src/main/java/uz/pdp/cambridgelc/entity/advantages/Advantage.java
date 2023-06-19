package uz.pdp.cambridgelc.entity.advantages;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;
import uz.pdp.cambridgelc.entity.icon.IconEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "advantages")
public class Advantage extends BaseEntity {
    private String title;
    private String description;

    @OneToOne
    private IconEntity icon;
}
