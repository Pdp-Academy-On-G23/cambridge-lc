package uz.pdp.cambridgelc.entity.teacherinfo;

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
@Entity(name = "teacher_info")
public class TeacherInfo extends BaseEntity {
    private String description;
    private Double score;
    private Double experience;
    private Long graduates;

    @OneToOne
    private UserEntity user;

    @OneToOne
    private AttachmentEntity attachment;
}
