package uz.pdp.cambridgelc.entity.communication;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;
import uz.pdp.cambridgelc.entity.icon.IconEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "popularQuesAns")
public class Communication extends BaseEntity {
    private String question;
    private String answer;

    @ManyToOne
    private IconEntity icon;
}
