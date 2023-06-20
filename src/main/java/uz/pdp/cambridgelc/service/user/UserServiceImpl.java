package uz.pdp.cambridgelc.service.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.cambridgelc.dto.request.UserLoginRequest;
import uz.pdp.cambridgelc.dto.request.UserRegisterRequest;
import uz.pdp.cambridgelc.dto.response.ApiResponse;
import uz.pdp.cambridgelc.entity.user.Role;
import uz.pdp.cambridgelc.entity.user.UserEntity;
import uz.pdp.cambridgelc.exception.DataNotFoundException;
import uz.pdp.cambridgelc.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse registerUser(UserRegisterRequest registerRequest) {

        if (userRepository.existsByPhoneNumber(registerRequest.getPhoneNumber()))
            return new ApiResponse("User already exists", false);

        UserEntity user = UserEntity.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .phoneNumber(registerRequest.getPhoneNumber())
                .password(registerRequest.getPassword())
                .build();

        user.setRole(getRole(registerRequest.getRoleId()));

        userRepository.save(user);
        return new ApiResponse("Successfully saved", true);

    }

    @Override
    public ApiResponse loginUser(UserLoginRequest loginRequest) {

        Role currentRole = getRole(loginRequest.getRoleId());

        if (!userRepository.existsByPhoneNumberAndPasswordAndRole(
                loginRequest.getPhoneNumber(), loginRequest.getPassword(), currentRole))
        return new ApiResponse("User not found", false);
        else return new ApiResponse("Successfully signed in", true);
    }

    @Override
    public ApiResponse deleteUser(Long id) {
        UserEntity user = userRepository.findUserEntityById(id).orElseThrow(
                () -> new DataNotFoundException("User not found")
        );
        user.setActive(true);
        userRepository.save(user);
        return new ApiResponse("Successfully deleted", true);
    }

    private Role getRole(int roleId) {
        if (roleId == 1)
            return Role.ADMIN;
        else if (roleId == 2)
            return Role.TEACHER;
        else return Role.TEACHER;
    }

}
