package uz.pdp.cambridgelc.entity.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;
import uz.pdp.cambridgelc.entity.branch.BranchEntity;
import uz.pdp.cambridgelc.entity.icon.IconEntity;
import uz.pdp.cambridgelc.entity.user.UserEntity;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "courses")
public class CourseEntity extends BaseEntity {
    private String title;
    private String description;

    @OneToOne
    private IconEntity icon;

    @ManyToOne
    private BranchEntity branch;

    @JsonIgnore
    @ManyToMany
    private Set<UserEntity> users;
}
