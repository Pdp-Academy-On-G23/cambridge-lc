package uz.pdp.cambridgelc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.cambridgelc.entity.user.Role;
import uz.pdp.cambridgelc.entity.user.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    @Query(value = "from users u where u.phoneNumber=:phoneNumber and u.role=:role and u.active=false ")
    Optional<UserEntity> findByPhoneNumberAndRole(String phoneNumber, Role role);

    @Query(value = "from users u where u.id=:id and u.active=false ")
    Optional<UserEntity> findUserEntityById(Long id);

    @Query(value = "from users u where u.active = false ")
    Page<UserEntity> findAllUsers(PageRequest of);

}
