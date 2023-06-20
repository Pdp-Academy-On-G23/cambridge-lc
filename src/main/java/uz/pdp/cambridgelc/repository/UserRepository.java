package uz.pdp.cambridgelc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.cambridgelc.entity.user.Role;
import uz.pdp.cambridgelc.entity.user.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByPhoneNumberAndPasswordAndRole(String phoneNumber, String password, Role role);

    @Query(value = "from users u where u.id=:id and u.active=false ")
    Optional<UserEntity> findUserEntityById(Long id);

}
