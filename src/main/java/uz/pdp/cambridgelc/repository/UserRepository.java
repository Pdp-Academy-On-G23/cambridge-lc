package uz.pdp.cambridgelc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.cambridgelc.entity.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
