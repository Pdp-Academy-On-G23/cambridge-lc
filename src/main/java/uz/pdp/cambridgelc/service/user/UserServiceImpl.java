package uz.pdp.cambridgelc.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.pdp.cambridgelc.dto.request.UserDTO;
import uz.pdp.cambridgelc.dto.request.UserUpdateDTO;
import uz.pdp.cambridgelc.dto.request.UserUpdateForAdminDTO;
import uz.pdp.cambridgelc.entity.user.Role;
import uz.pdp.cambridgelc.entity.user.UserEntity;
import uz.pdp.cambridgelc.exception.DataNotFoundException;
import uz.pdp.cambridgelc.exception.DuplicateValueException;
import uz.pdp.cambridgelc.repository.UserRepository;

import static uz.pdp.cambridgelc.mapper.UserMapper.USER_MAPPER;
import static uz.pdp.cambridgelc.mapper.UserMapperForAdmin.USER_MAPPER_FOR_ADMIN;
import static uz.pdp.cambridgelc.mapper.UserUpdateMapper.USER_UPDATE_MAPPER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void deleteUser(Long id) {
        UserEntity user = getUserById(id);
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public UserEntity editeUser(Long id, UserUpdateDTO dto) {
        UserEntity user = getUserById(id);
        return userRepository.save(USER_MAPPER.partialUpdate(dto, user));
    }

    @Override
    public UserEntity editeUserForAdmin(Long id, UserUpdateForAdminDTO userUpdateDTO) {
        UserEntity user = getUserById(id);
        Role role = getRole(userUpdateDTO.getRoleId());
        user.setRole(role);
        return userRepository.save(USER_UPDATE_MAPPER.partialUpdate(userUpdateDTO, user));
    }

    @Override
    public Page<UserEntity> getAll(Integer page, Integer size) {
        return userRepository.findAllUsers(PageRequest.of(page, size));
    }

    @Override
    public UserEntity getById(Long id) {
        return getUserById(id);
    }

    @Override
    public UserEntity addUser(UserDTO userDTO) {
        if (userRepository.existsByPhoneNumber(userDTO.getPhoneNumber()))
            throw new DuplicateValueException("This user already exists");
        UserEntity user = USER_MAPPER_FOR_ADMIN.toEntity(userDTO);
        Role role = getRole(userDTO.getRoleId());
        user.setRole(role);
        return userRepository.save(user);
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findUserEntityById(id).orElseThrow(
                () -> new DataNotFoundException("User not found")
        );
    }

    private Role getRole(Integer roleId) {
        if (roleId == 1)
            return Role.ADMIN;
        else if (roleId == 2)
            return Role.TEACHER;
        else return Role.STUDENT;
    }

}
