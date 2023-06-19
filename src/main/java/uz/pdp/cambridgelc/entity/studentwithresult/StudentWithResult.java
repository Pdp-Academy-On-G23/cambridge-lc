package uz.pdp.cambridgelc.entity.studentwithresult;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;
import uz.pdp.cambridgelc.entity.attachment.AttachmentEntity;
import uz.pdp.cambridgelc.entity.user.UserEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "studentswithresults")
public class StudentWithResult extends BaseEntity {
    private Double speakingScore;
    private Double readingScore;
    private Double writingScore;
    private Double listeningScore;
    private Double overallScore;

    @OneToOne
    private AttachmentEntity attachment;

    @OneToOne
    private UserEntity user;
}
