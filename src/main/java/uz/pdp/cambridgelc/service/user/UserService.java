package uz.pdp.cambridgelc.service.user;

import org.springframework.data.domain.Page;
import uz.pdp.cambridgelc.dto.request.UserDTO;
import uz.pdp.cambridgelc.dto.request.UserUpdateDTO;
import uz.pdp.cambridgelc.dto.request.UserUpdateForAdminDTO;
import uz.pdp.cambridgelc.entity.user.UserEntity;

public interface UserService {

    void deleteUser(Long id);

    UserEntity editeUser(Long id, UserUpdateDTO userUpdateDTO);

    UserEntity getById(Long id);

    UserEntity addUser(UserDTO userDTO);

    Page<UserEntity> getAll(Integer page, Integer size);

    UserEntity editeUserForAdmin(Long id, UserUpdateForAdminDTO userUpdateDTO);
}
