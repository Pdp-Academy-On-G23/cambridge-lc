package uz.pdp.cambridgelc.entity.user;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.cambridgelc.entity.BaseEntity;
import uz.pdp.cambridgelc.entity.course.CourseEntity;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "users")
public class UserEntity extends BaseEntity {

    @Column(unique = true)
    private String phoneNumber;

    private String password;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean active = true;

    @ManyToMany
    @JoinTable(
            name = "users_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<CourseEntity> courses;

    @PrePersist
    public void setDefaultActive() {
        this.active = false;
    }
}
