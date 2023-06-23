package uz.pdp.cambridgelc.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.cambridgelc.dto.request.UserLoginRequest;
import uz.pdp.cambridgelc.dto.response.ApiResponse;
import uz.pdp.cambridgelc.entity.user.Role;
import uz.pdp.cambridgelc.entity.user.UserEntity;
import uz.pdp.cambridgelc.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    @Override
    public ApiResponse loginUser(UserLoginRequest loginRequest) {

        Role currentRole = getRole(loginRequest.getRoleId());

        Optional<UserEntity> signingUser = userRepository.findByPhoneNumberAndRole(
                loginRequest.getPhoneNumber(), currentRole);
        if (signingUser.isEmpty())
        return new ApiResponse("User not found", false);
        else return new ApiResponse("Successfully signed in", true);
    }

    private Role getRole(int roleId) {
        if (roleId == 1)
            return Role.ADMIN;
        else if (roleId == 2)
            return Role.TEACHER;
        else return Role.TEACHER;
    }
}
